package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_COACH = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_CANT_EAT_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String readCoach() {
        return userInput(INPUT_COACH);
    }

    public String readCantEatMenu(String name) {
        return userInput(name + INPUT_CANT_EAT_MENU);
    }

    private String userInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
