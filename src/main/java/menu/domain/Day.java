package menu.domain;

public enum Day {
    월요일,
    화요일,
    수요일,
    목요일,
    금요일;

    public static Day findDay(String input) {
        for (Day day : Day.values()) {
            if (day.name().equals(input)) return day;
        }
        throw new IllegalArgumentException("없는 요일입니다.");
    }
}
