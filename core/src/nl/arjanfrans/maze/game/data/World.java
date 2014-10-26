package nl.arjanfrans.maze.game.data;

import com.badlogic.gdx.utils.Array;
import nl.arjanfrans.maze.MasterMaze;
import nl.arjanfrans.maze.debug.D;
import nl.arjanfrans.maze.game.entities.*;
import nl.arjanfrans.maze.game.events.TimeLimitReached;
import nl.arjanfrans.maze.game.map.Map;
import nl.arjanfrans.maze.utils.Timer;

import java.util.Iterator;

/**
 * This class holds all the entitys, player, map data that exists in the world.
 */
public class World {
    protected final MasterMaze game;
    protected Array<Moveable> movables = new Array<Moveable>();
    protected Array<Controllable> controllables = new Array<Controllable>();
    protected Array<Drawable> drawables = new Array<Drawable>();
    protected Array<Decoration> decorations = new Array<Decoration>();
    protected Player player;
    protected WorldGenerator generator;
    private Timer timer = new Timer();

    public static final int SCALE = 32;

    protected Map map;

    protected boolean stop = true;

    public World(MasterMaze game) {
        this.game = game;
        this.generator = new WorldGenerator(this);
        this.initialize();
    }

    public Timer getTimer() {
        return this.timer;
    }

    public void initialize() {
        this.timer = new Timer();
        this.generator.generate();
    }

    public void update() {
        if(!stop && timer.isFinished()) {
            new TimeLimitReached(this.game);
        }
    }

    public void setTimeLimit(int timeLimit) {
        this.timer.setDuration(timeLimit);
    }

    /**
     * Start the level
     */
    public void start() {
        this.player.setInputEnabled(true);
        this.timer.start();
        this.stop = false;
        D.o("Level started");
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return this.map;
    }

    /**
     * Add an entity to the world.
     * @param entity
     */
    public void addEntity(Entity entity) {
        if(entity instanceof Moveable) {
            movables.add((Moveable) entity);
        }
        if(entity instanceof Controllable) {
            controllables.add((Controllable) entity);
        }
        if(entity instanceof Drawable) {
            drawables.add((Drawable) entity);
        }
        if(entity instanceof Decoration) {
            decorations.add((Decoration) entity);
        }
        if(entity instanceof Player) {
            player = (Player) entity;
        }
    }

    /**
     * Add an array of entities to the world.
     * @param entities
     */
    public void addEntities(Array<Entity> entities) {
        Iterator<Entity> entityIterator = entities.iterator();
        while(entityIterator.hasNext()) {
            this.addEntity(entityIterator.next());
        }
    }

    public void removeEntity(Entity entity) {
        controllables.removeValue((Controllable) entity, true);
        movables.removeValue((Moveable) entity, true);
        drawables.removeValue((Drawable) entity, true);
    }

    public Array<Moveable> getMovables() {
        return movables;
    }

    public Array<Controllable> getControllables() {
        return controllables;
    }

    public Array<Drawable> getDrawables() {
        return drawables;
    }

    public Array<Decoration> getDecorations() {
        return decorations;
    }

    public Player getPlayer() {
        return player;
    }

    public void setStop(boolean stop) {
        this.timer.stop();
        this.stop = stop;
    }
}
