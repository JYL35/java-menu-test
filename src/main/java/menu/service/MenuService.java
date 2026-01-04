package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;
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
        Category category = shuffledCategory();
    }

    private Category shuffledCategory() {
        Category category = Category.findCategory(Randoms.pickNumberInRange(1, 5));
        if (RecommendHistory.hasSelectedCategoryBefore(category)) {
            return shuffledCategory();
        }
        return category;
    }
}
