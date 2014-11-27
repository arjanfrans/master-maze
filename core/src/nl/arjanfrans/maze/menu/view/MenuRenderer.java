package nl.arjanfrans.maze.menu.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import nl.arjanfrans.maze.Config;
import nl.arjanfrans.maze.components.input.GameInput;
import nl.arjanfrans.maze.components.view.AbstractRenderer;
import nl.arjanfrans.maze.menu.data.Menu;
import nl.arjanfrans.maze.menu.input.MenuControls;
import nl.arjanfrans.maze.menu.input.MenuItemListener;

public class MenuRenderer extends AbstractRenderer{

    protected Menu menu;
    protected Stage stage;

    protected Table table;
    protected MenuItem[] items;
    protected Skin skin;
    protected MenuControls controls;

    public MenuRenderer(Menu menu) {
        this.menu = menu;
        this.controls = menu.getControls();
        this.skin = new Skin();
        this.stage = new Stage();
        this.createTable();
    }

    protected void createTable() {
        table = new Table();
        table.setFillParent(true);
        table.add(new MenuTitle(this.menu.getTitle()).getTitle()).pad(50);
        createMenu();
        stage.addActor(table);
    }

    protected void createMenu() {
        String[] items = menu.getMenuItemKeys();
        this.items = new MenuItem[items.length];
        for(int i = 0; i < items.length; i++) {
            table.row();
            MenuItem item = new MenuItem(items[i]);
            item.getItem().addListener(new MenuItemListener(menu, i));
            this.items[i] = item;
            table.add(item.getItem()).pad(30);
        }
    }

    public void update(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        this.batch.setProjectionMatrix(camera.combined);

        this.batch.begin();

        if(Config.DEBUG) table.debug(); // turn on all debug lines (table, cell, and widget)
        updateItems();
        stage.act();
        stage.draw();

        this.batch.end();
    }

    protected void updateItems() {
        for(int i = 0; i < items.length; i++) {
            if(menu.getCurrentItem() == i) items[i].getItem().setChecked(true);
            else items[i].getItem().setChecked(false);
        }
    }

    public Stage getStage() {
        return stage;
    }

}
