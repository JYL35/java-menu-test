package menu.domain;

import java.util.List;

public class Coach {
    private final String name;
    private final List<String> cantEatMenu;


    public Coach(String name, List<String> cantEatMenu) {
        this.name = name;
        this.cantEatMenu = cantEatMenu;
    }

    public boolean cantYouEat(String menu) {
        return cantEatMenu.contains(menu);
    }

    public String getName() {
        return name;
    }
}
