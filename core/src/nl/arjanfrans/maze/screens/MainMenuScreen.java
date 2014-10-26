package nl.arjanfrans.maze.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import nl.arjanfrans.maze.MasterMaze;
import nl.arjanfrans.maze.components.input.GameInput;
import nl.arjanfrans.maze.menu.input.MenuControls;
import nl.arjanfrans.maze.menu.data.Menu;
import nl.arjanfrans.maze.menu.view.MenuRenderer;


public class MainMenuScreen implements Screen {

    final MasterMaze game;
    protected Menu menu;
    protected MenuControls controls;
    protected MenuRenderer renderer;

    public MainMenuScreen(final MasterMaze game) {
        this.game = game;
        this.menu = new Menu(this.game);
        this.controls = new MenuControls(this.menu);
        this.renderer = new MenuRenderer(this.menu, this.controls);

    }




    @Override
    public void render(float delta) {
        this.controls.update(this.game);
        this.renderer.update(delta);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }


    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        this.renderer.dispose();
    }


}