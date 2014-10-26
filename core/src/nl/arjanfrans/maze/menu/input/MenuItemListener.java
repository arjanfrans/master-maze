package nl.arjanfrans.maze.menu.input;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import nl.arjanfrans.maze.menu.data.Menu;

public class MenuItemListener extends ClickListener {
    protected Menu menu;
    protected int item;

    public MenuItemListener(Menu menu, int item) {
        this.menu = menu;
        this.item = item;
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        this.menu.setCurrentItem(item);
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        this.menu.setCurrentItem(item);
        this.menu.select();
    }
}
