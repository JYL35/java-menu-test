package menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.service.MenuService;
import menu.util.Parser;
import menu.util.Validator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final MenuService menuService;
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(MenuService menuService, InputView inputView, OutputView outputView) {
        this.menuService = menuService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            String coachInput = inputView.readCoach();
            List<String> coaches = Parser.parseSeparator(coachInput);
            Validator.validateCoach(coaches);

            inputCantEatMenu(coaches);

        } catch (RuntimeException e) {
            outputView.printError(e);
            start();
        }
    }

    private void inputCantEatMenu(List<String> coaches) {
        try {
            Map<String, List<String>> allCoachCantEatMenu = new HashMap<>();
            for (String coach : coaches) {
                String cantEatInput = inputView.readCantEatMenu(coach);
                List<String> cantEatMenu = Parser.parseSeparator(cantEatInput);
                Validator.validateCantEatMenu(cantEatMenu);
                allCoachCantEatMenu.put(coach, cantEatMenu);
            }
            outputView.printStartPhrase();
            menuService.createCoach(allCoachCantEatMenu);
            menuService.startRecommend();
            outputView.printRecommendedResults();
        } catch (RuntimeException e) {
            outputView.printError(e);
            inputCantEatMenu(coaches);
        }
    }
}
