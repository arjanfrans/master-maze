package nl.arjanfrans.maze;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import nl.arjanfrans.maze.assets.Assets;
import nl.arjanfrans.maze.components.input.GameInput;
import nl.arjanfrans.maze.components.input.GameKeys;
import nl.arjanfrans.maze.game.maze.MazeGenerator;
import nl.arjanfrans.maze.screens.GameScreen;
import nl.arjanfrans.maze.screens.MainMenuScreen;

public class MasterMaze extends Game {
    public static final boolean DEBUG = true;

    public void create() {
        //TODO create GameState system
        Gdx.input.setInputProcessor(new GameInput());
        //this.setScreen(new GameScreen(this));
        this.setScreen(new MainMenuScreen(this));
//        MazeGenerator m = new MazeGenerator();
//        m.generate(8, 8, 1, 1, 32, 32);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void setScreen(Screen screen) {
        super.setScreen(screen);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
        GameKeys.update();
    }

    @Override
    public void dispose() {
        super.dispose();
        if(this.getScreen() != null) this.getScreen().dispose();
        Assets.manager.dispose();
    }
}
