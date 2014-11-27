package nl.arjanfrans.maze.menu.actions;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import nl.arjanfrans.maze.MasterMaze;

public class ScreenAction implements MenuAction {
    protected String screenName;
    protected MasterMaze game;

    public ScreenAction(MasterMaze game, String screenName) {
        this.game = game;
        this.screenName = screenName;
    }

    @Override
    public void act() {
        game.setScreen(MasterMaze.screens.get(screenName));
    }
}
