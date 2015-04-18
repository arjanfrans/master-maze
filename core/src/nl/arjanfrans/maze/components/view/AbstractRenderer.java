package nl.arjanfrans.maze.components.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import nl.arjanfrans.maze.components.SystemInterface;

public abstract class AbstractRenderer implements SystemInterface, Disposable {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    protected SpriteBatch batch = new SpriteBatch();
    protected OrthographicCamera camera = new OrthographicCamera();

    public AbstractRenderer() {
        setupCamera();
    }

    protected void setupCamera() {
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, WIDTH, HEIGHT);
    }


    public void resize(float width, float height) {
        float aspectRatio = width / height;
        this.camera.setToOrtho(false, 2f * aspectRatio, 2f);

    }

    public void dispose() {
        batch.dispose();
    }

}
