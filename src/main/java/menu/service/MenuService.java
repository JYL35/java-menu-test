package menu.service;

import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.repository.CoachRepository;

public class MenuService {

    public void createCoach(Map<String, List<String>> allCoachCantEatMenu) {
        for (String coachName : allCoachCantEatMenu.keySet()) {
            List<String> cantEatMenu = allCoachCantEatMenu.get(coachName);
            CoachRepository.addCoach(new Coach(coachName, cantEatMenu));
        }
    }
}
