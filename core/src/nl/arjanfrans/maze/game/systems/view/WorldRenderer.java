package nl.arjanfrans.maze.game.systems.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import nl.arjanfrans.maze.game.entities.Decoration;
import nl.arjanfrans.maze.game.entities.Drawable;
import nl.arjanfrans.maze.components.view.AbstractRenderer;
import nl.arjanfrans.maze.game.data.World;

import java.util.Iterator;

public class WorldRenderer extends AbstractRenderer {

    protected World world;
    protected Iterator<Decoration> decorationIterator;

    public WorldRenderer(World world) {
        this.world = world;
    }


    public void update(float delta) {
        this.updateCamera(delta);

        this.batch.setProjectionMatrix(camera.combined);
        this.batch.begin();
        this.drawEntities();
        this.batch.end();

    }

    protected void updateCamera(float delta) {
        //TODO fixe camera follow 'lag', because of the timestep fix
        float smoothing = 0.1f * 40f; // the lower the smoother
        camera.position.lerp(world.getPlayer().getVector3Position(), 1);// smoothing * delta);

        camera.update();
    }

    protected void drawEntities() {
        //TODO ensure order (do by checking for Decoration, Movable, Player etc.
        this.decorationIterator = world.getDecorations().iterator();
        while(decorationIterator.hasNext()) {
            decorationIterator.next().draw(this.batch);
        }
        world.getPlayer().draw(this.batch);
    }

    @Override
    public void resize(float width, float height) {

    }

    @Override
    public void dispose() {
        this.batch.dispose();
    }
}
