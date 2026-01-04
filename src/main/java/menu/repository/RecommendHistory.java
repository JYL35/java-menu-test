package menu.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;

public class RecommendHistory {

    private static Map<Coach, Map<Day, String>> eatHistory = new HashMap<>();
    private static Map<Day, Category> categoryHistory = new HashMap<>();

    public static void save(Coach coach, Day day, Category category, String menu) {
//        eatHistory.computeIfAbsent(coach, k -> new HashMap<>())
//                .computeIfAbsent(day, k -> menu);
        Map<Day, String> dayHistory = eatHistory.getOrDefault(coach, new HashMap<>());
        dayHistory.put(day, menu);
        eatHistory.put(coach, dayHistory);

        categoryHistory.put(day, category);
    }

    public static boolean hasEatBefore(Coach coach, String menu) {
        if (!eatHistory.containsKey(coach)) return false;

        for (String eatMenu : eatHistory.get(coach).values()) {
            if (eatMenu.equals(menu)) return true;
        }
        return false;
    }

    public static boolean hasSelectedCategoryBefore(Category category) {
        int count = 0;
        for (Category selectedCategory : categoryHistory.values()) {
            if (selectedCategory.equals(category)) {
                count++;
            }
            if (count == 2) return true;
        }
        return false;
    }

    public static List<String> formattedEatHistory() {
        List<String> result = new ArrayList<>();

        for (Coach coach : CoachRepository.coachs()) {
            result.add(formattedCoachEatHistory(coach));
        }

        return result;
    }

    public static String formattedCategoryHistory() {
        String result = "[ 카테고리";

        for (Day day : Day.values()) {
            result += " | " + categoryHistory.get(day).name();
        }

        return result + " ]";
    }

    private static String formattedCoachEatHistory(Coach coach) {
        String result = "[ " + coach.getName();

        for (Day day : Day.values()) {
            result += " | " + eatHistory.get(coach).get(day);
        }
        return result + " ]";
    }
}
