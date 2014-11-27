package nl.arjanfrans.maze.game.systems.input;

import com.badlogic.gdx.Game;
import nl.arjanfrans.maze.MasterMaze;
import nl.arjanfrans.maze.components.input.GameKeys;
import nl.arjanfrans.maze.game.entities.Controllable;
import nl.arjanfrans.maze.game.map.Map;

public class GlobalGameInput implements Controllable {
    private MasterMaze game;

    public GlobalGameInput(MasterMaze game) {
        this.game = game;
    }

    @Override
    public void input() {
        if(GameKeys.isDown(GameKeys.ESCAPE)) {
            game.setScreen(game.getMainMenuScreen());
        }
    }

    @Override
    public boolean isInputEnabled() {
        return true;
    }
}
