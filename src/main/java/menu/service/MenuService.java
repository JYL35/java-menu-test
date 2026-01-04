package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.repository.CoachRepository;
import menu.repository.RecommendHistory;

public class MenuService {

    public void createCoach(Map<String, List<String>> allCoachCantEatMenu) {
        for (String coachName : allCoachCantEatMenu.keySet()) {
            List<String> cantEatMenu = allCoachCantEatMenu.get(coachName);
            CoachRepository.addCoach(new Coach(coachName, cantEatMenu));
        }
    }

    public void startRecommend() {
        for (Day day : Day.values()) {
            dayRecommend(day);
        }
    }

    private void dayRecommend(Day day) {
        Category category = shuffledCategory();
        for (Coach coach : CoachRepository.coachs()) {
            String menu = shuffledMenu(coach, category.getMenu());
            RecommendHistory.save(coach, day, category, menu);
        }
    }

    private Category shuffledCategory() {
        Category category = Category.findCategory(Randoms.pickNumberInRange(1, 5));
        if (RecommendHistory.hasSelectedCategoryBefore(category)) {
            return shuffledCategory();
        }
        return category;
    }

    private String shuffledMenu(Coach coach, List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);
        if (coach.cantYouEat(menu)) {
            return shuffledMenu(coach, menus);
        }
        if (RecommendHistory.hasEatBefore(coach, menu)) {
            return shuffledMenu(coach, menus);
        }
        return menu;
    }
}
