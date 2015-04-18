package nl.arjanfrans.maze.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.utils.TimeUtils;
import nl.arjanfrans.maze.Config;
import nl.arjanfrans.maze.MasterMaze;
import nl.arjanfrans.maze.components.input.GameInput;
import nl.arjanfrans.maze.components.input.GameKeys;
import nl.arjanfrans.maze.debug.FPS;
import nl.arjanfrans.maze.game.data.World;
import nl.arjanfrans.maze.game.data.WorldGenerator;
import nl.arjanfrans.maze.game.systems.events.EventHandler;
import nl.arjanfrans.maze.game.systems.input.WorldInput;
import nl.arjanfrans.maze.game.systems.movement.WorldMovement;
import nl.arjanfrans.maze.game.systems.view.ControllerOverlay;
import nl.arjanfrans.maze.game.systems.view.HudRenderer;
import nl.arjanfrans.maze.game.systems.view.WorldRenderer;


public class GameScreen implements Screen, InputScreen {
    protected final MasterMaze game;

    protected WorldInput input;
    protected WorldMovement movement;
    protected WorldRenderer renderer;
    protected EventHandler events;
    protected HudRenderer hud;
    protected ControllerOverlay controllerOverlay;
    protected World world;

    public static final long RENDERER_SLEEP_MS = 0; // 34 -> 30 fps, 30 -> 34 fps, 22 gives ~46 FPS, 20 = 100, 10 = 50
    private long now, diff, start;

    private float dt;
    private float accumulator = 0;

    public GameScreen(final MasterMaze game) {
        this.game = game;
        this.world = new World(this.game);
        this.input = new WorldInput(this.world);
        this.movement = new WorldMovement(this.world);
        this.hud = new HudRenderer(this.world);
        this.controllerOverlay = new ControllerOverlay(this.world);
        this.renderer = new WorldRenderer(this.world);
        this.events = new EventHandler(this.world);
        dt = 1/75f; // Logic updates approx. @ 75 hz

    }

    @Override
    public void render(float delta) {
        if(Config.DEBUG) FPS.preCheck();
        if(delta > 0.25f) delta = 0.25f; // Max frame time to avoid spiral of death

        accumulator += delta;
        this.input.update(delta);
        while (accumulator >= dt) {
            this.movement.copyCurrentPosition();
            this.updating(dt);
            accumulator -= dt;
            this.movement.interpolateCurrentPosition(accumulator / dt);
            if(Config.DEBUG) FPS.postCheck();
        }
        this.rendering(delta);
        this.limitFPS();
    }

    /**
     * Update the game logic.
     * @param delta
     */
    protected void updating(float delta) {
        this.events.update(delta);
        this.world.update();
        this.movement.update(delta);
    }

    /**
     * Update the game graphics.
     * @param delta
     */
    protected void rendering(float delta) {
        this.renderer.update(delta);
        this.hud.update(delta);
        this.controllerOverlay.update(delta);
    }

    /**
     * Limit the frame rate.
     */
    protected void limitFPS() {
        if (RENDERER_SLEEP_MS > 0) {
            now = TimeUtils.millis();
            diff = now - start;
            if(diff < RENDERER_SLEEP_MS) {
                try {
                    Thread.sleep(RENDERER_SLEEP_MS - diff);
                } catch (InterruptedException e) {}
            }
            start = TimeUtils.millis();
        }
    }


    @Override
    public void resize(int width, int height) {
        this.renderer.resize((float) width, (float) height);
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

    @Override
    public InputMultiplexer getInputMultiplexer() {
        return new InputMultiplexer(new GameInput(), this.controllerOverlay.getStage());
    }
}