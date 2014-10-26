package nl.arjanfrans.maze.menu.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ArrayMap;
import nl.arjanfrans.maze.MasterMaze;
import nl.arjanfrans.maze.components.input.GameKeys;
import nl.arjanfrans.maze.debug.D;
import nl.arjanfrans.maze.menu.data.Menu;
import nl.arjanfrans.maze.menu.view.MenuItem;

public class MenuControls {
    protected Menu menu;
    protected ArrayMap<String, MenuItem> menuItems = new ArrayMap<String, MenuItem>();

    public MenuControls(Menu menu) {
        this.menu = menu;
    }


    public void update(MasterMaze game) {
        if(GameKeys.isPressed(GameKeys.UP)) {
            this.menu.moveUp();
        }
        if(GameKeys.isPressed(GameKeys.DOWN)) {
            this.menu.moveDown();
        }
        if(GameKeys.isPressed(GameKeys.ENTER)) {
            this.menu.select();
        }
    }

    public void addMenuItem(String name, MenuItem item) {
        this.menuItems.put(name, item);
    }




}
