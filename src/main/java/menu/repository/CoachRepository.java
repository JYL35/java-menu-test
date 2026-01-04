package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import menu.constant.ErrorMessage;
import menu.domain.Coach;

public class CoachRepository {
    private static final List<Coach> coachs = new ArrayList<>();

    public static List<Coach> coachs() {
        return Collections.unmodifiableList(coachs);
    }

    public static void addCoach(Coach coach) {
        coachs.add(coach);
    }

    public static boolean deleteCoach(String name) {
        return coachs.removeIf(coach -> Objects.equals(coach.getName(), name));
    }

    public static void deleteAll() {
        coachs.clear();
    }

    public static Coach findByName(String name) {
        return coachs.stream()
                .filter(coach -> Objects.equals(coach.getName(), name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.COACHES_OUT_OF_RANGE.getMessage()));
    }
}
