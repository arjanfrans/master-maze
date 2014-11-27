package nl.arjanfrans.maze.menu.data;

import com.badlogic.gdx.utils.ArrayMap;
import nl.arjanfrans.maze.MasterMaze;
import nl.arjanfrans.maze.menu.actions.MenuAction;
import nl.arjanfrans.maze.menu.actions.ScreenAction;
import nl.arjanfrans.maze.screens.MainMenuScreen;

public class HighscoreMenu extends Menu {

    public HighscoreMenu(MasterMaze game) {
        super(game);
        ArrayMap<String, MenuAction> items = new ArrayMap<String, MenuAction>();
        items.put("Back", new ScreenAction(game, "mainMenu"));
        this.setMenuItems(items);
    }
}
