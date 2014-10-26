package nl.arjanfrans.maze.menu.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ArrayMap;
import nl.arjanfrans.maze.Config;
import nl.arjanfrans.maze.MasterMaze;
import nl.arjanfrans.maze.menu.input.MenuControls;
import nl.arjanfrans.maze.screens.GameScreen;

public class Menu {
    private int currentItem;
    private String[] menuItems;
    private String title;
    private MasterMaze game;

    public Menu(MasterMaze game) {
        this.game = game;
        this.menuItems = new String[]{"Play", "Highscores", "Quit"};
        this.title = Config.TITLE;

    }

    public void moveUp() {
        if(this.currentItem > 0) this.currentItem--;
    }

    public void moveDown() {
        if(this.currentItem < menuItems.length - 1) this.currentItem++;
    }

    public void select() {
        if(this.currentItem == 0) {
            this.game.setScreen(new GameScreen(this.game));
        }
        if(this.currentItem == 1) {
            //TODO create highscore system
        }
        if(this.currentItem == 2) {
            Gdx.app.exit();
        }
    }

    public void setCurrentItem(int item) {
        this.currentItem = item;
    }

    public int getCurrentItem() {
        return this.currentItem;
    }

    public String getTitle() {
        return this.title;
    }

    public String[] getMenuItems() {
        return this.menuItems;
    }


}
