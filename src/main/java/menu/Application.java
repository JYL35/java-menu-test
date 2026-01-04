package menu;

import menu.controller.MenuController;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MenuController menuController = new MenuController(
                new MenuService(), new InputView(), new OutputView()
        );
        menuController.start();
    }
}
