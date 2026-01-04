package menu.util;

import java.util.List;
import java.util.stream.Collectors;
import menu.constant.ErrorMessage;

public class Validator {

    public static void validateCoach(List<String> input) {
        validateCount(input.size(), 2, 5, ErrorMessage.COACHES_OUT_OF_RANGE);

        for (String coach : input) {
            validateEmpty(coach);
            validateCount(coach.length(), 2, 4, ErrorMessage.COACH_NAME_OUT_OF_RANGE);
        }

        validateDuplicate(input, ErrorMessage.COACHES_OVERLAP);
    }

    public static void validateCantEatMenu(List<String> input) {
        if (input.isEmpty()) return;

        validateCount(input.size(), 0, 2, ErrorMessage.MENU_COUNT_OUT_OF_RANGE);

        for (String menu : input) {
            validateEmpty(menu);
            // 메뉴가 정해진 목록에 존재하는 메뉴인지 확인 (검증하지 않아도 상관 없음)
        }

        validateDuplicate(input, ErrorMessage.MENU_OVERLAP);
    }

    private static void validateCount(int size, int min, int max, ErrorMessage errorMessage) {
        if (size < min || size > max) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_EMPTY.getMessage());
        }
    }

    private static void validateDuplicate(List<String> input, ErrorMessage errorMessage) {
        List<String> tempInput = input.stream()
                .distinct()
                .collect(Collectors.toList());

        if (input.size() != tempInput.size()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
