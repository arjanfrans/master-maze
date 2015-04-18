package nl.arjanfrans.maze.game.systems.view;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import nl.arjanfrans.maze.Config;
import nl.arjanfrans.maze.components.input.GameKeys;
import nl.arjanfrans.maze.components.view.AbstractRenderer;
import nl.arjanfrans.maze.game.data.World;

public class ControllerOverlay extends AbstractRenderer {

    private Stage stage = new Stage();
    private World world;
    private Table table;
    private ControllerButton up;
    private ControllerButton down;
    private ControllerButton left;
    private ControllerButton right;


    public ControllerOverlay(World world) {
        this.world = world;
        createTable();
    }

    public Stage getStage() {
        return this.stage;
    }

    protected void createTable() {
        up = new ControllerButton(GameKeys.UP, false, false, false);
        down = new ControllerButton(GameKeys.DOWN, false, true, false);
        left = new ControllerButton(GameKeys.LEFT, true, false, true);
        right = new ControllerButton(GameKeys.RIGHT, false, false, true);

        table = new Table();
        table.setFillParent(true);
        table.bottom().left();
        table.add(up.getButton()).colspan(3);
        table.row();
        table.add(left.getButton()).colspan(1).pad(30);
        table.add(right.getButton()).colspan(1).pad(30).right();
        table.row();
        table.add(down.getButton()).colspan(3);
        stage.addActor(table);
    }

    @Override
    public void update(float delta) {
        this.camera.update();
        this.batch.setProjectionMatrix(camera.combined);
        this.batch.begin();

        if(Config.DEBUG) table.debug(); // turn on all debug lines (table, cell, and widget)
        stage.act();
        stage.draw();
//        if(Config.DEBUG) Table.drawDebug(stage); // draw any enabled debug lines

        this.batch.end();
    }

}
