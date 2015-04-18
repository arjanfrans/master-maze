package nl.arjanfrans.maze.game.entities;

import com.badlogic.gdx.math.Vector2;
import nl.arjanfrans.maze.game.map.Map;
import nl.arjanfrans.maze.game.map.Tile;

public abstract class MoveableEntity extends Entity implements Moveable {

    public Vector2 positionPrevious = new Vector2();
    protected float speed = 32 / 0.2f;
    protected Tile nextTile;
    protected enum Direction {
        UP, DOWN, LEFT, RIGHT
    };
    protected Direction direction;
    protected boolean stop = false;

    private static final String LAYER = "grass"; // Tile layer

    public MoveableEntity(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    protected Tile currentTile(Map map) {
        // Only useful if player is not moving
        return map.getLayer(LAYER).getTileFromGrid(this.getX() + 16, this.getY() + 16);
    }

    public boolean isStopped() {
        return this.stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }


    protected void getNextTile(Map map, float x, float y) {
        int tileWidth = map.getLayer(LAYER).getTileWidth();
        int tileHeight = map.getLayer(LAYER).getTileHeight();
        if(direction == Direction.UP) {
            this.nextTile = map.getLayer(LAYER).getTileFromGrid(x + tileWidth / 2, y + (tileHeight * 1.5f));
        }
        else if(direction == Direction.DOWN) {
            this.nextTile = map.getLayer(LAYER).getTileFromGrid(x + tileWidth / 2, y - tileHeight / 2);
        }
        else if(direction == Direction.RIGHT) {
            this.nextTile = map.getLayer(LAYER).getTileFromGrid(x + (tileWidth * 1.5f), y + tileHeight / 2);
        }
        else if(direction == Direction.LEFT) {
            this.nextTile = map.getLayer(LAYER).getTileFromGrid(x - tileWidth / 2, y + tileHeight / 2);
        }
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return this.speed;
    }
}
