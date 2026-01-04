package menu.repository;

import java.util.HashMap;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;

public class RecommendHistory {

    private static Map<Coach, Map<Day, String>> eatHistory = new HashMap<>();
    private static Map<Day, Category> categoryHistory = new HashMap<>();

    public static void save(Coach coach, Day day, Category category, String menu) {
        eatHistory.computeIfAbsent(coach, k -> new HashMap<>())
                .computeIfAbsent(day, k -> menu);
        categoryHistory.put(day, category);
    }

    public static boolean hasEatBefore(Coach coach, String menu) {
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
}
