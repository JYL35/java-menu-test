package menu.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<String> parseSeparator(String input) {
        if (input == null || input.isBlank()) {
            return List.of();
        }

        List<String> result = new ArrayList<>();

        for (String str : input.split(",")) {
            result.add(str.strip());
        }

        return List.copyOf(result);
    }
}
