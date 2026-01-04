package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        while (true) {
            try {
                String coachInput = inputView.readCoach();
                // 코치 파싱
                // 코치 유효성 검사

                // 각 코치들 못 먹는 음식 입력 받기 -> 음식들 각각 파싱 및 유효성 검사

                // 메뉴 추천
            } catch (RuntimeException e) {
                outputView.printError(e);
            }
        }
    }
}
