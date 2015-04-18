package nl.arjanfrans.maze.game.systems.view;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import nl.arjanfrans.maze.Config;
import nl.arjanfrans.maze.components.SystemInterface;
import nl.arjanfrans.maze.components.view.AbstractRenderer;
import nl.arjanfrans.maze.game.data.World;
import nl.arjanfrans.maze.game.stats.Stats;

public class HudRenderer extends AbstractRenderer implements SystemInterface {
    private Stage stage = new Stage();
    private World world;
    private Table table;

    private HudLabel time;
    private HudLabel level;

    public HudRenderer(World world) {
        this.world = world;
        createTable();
    }

    protected void createTable() {
        time = new HudLabel("Time: ");
        level = new HudLabel("Level: ");
        table = new Table();
        table.setFillParent(true);
        table.right().top();
        table.add(time.getLabel()).space(10).pad(2).padLeft(20).padRight(40).minWidth(150);
        table.add(level.getLabel()).space(10).pad(2).padRight(40).minWidth(150);
        stage.addActor(table);
    }

    @Override
    public void update(float delta) {
        this.camera.update();
        this.batch.setProjectionMatrix(camera.combined);
        this.batch.begin();

        if(Config.DEBUG) table.debug(); // turn on all debug lines (table, cell, and widget)
        this.updateStats();
        stage.act();
        stage.draw();
//        if(Config.DEBUG) Table.drawDebug(stage); // draw any enabled debug lines

        this.batch.end();
    }

    protected void updateStats() {
        this.time.setText("Time: " + this.world.getTimer().getRemainingTime());
        this.level.setText("Level: " + Stats.level);
    }


}
