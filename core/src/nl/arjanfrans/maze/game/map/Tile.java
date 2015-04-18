package nl.arjanfrans.maze.game.map;

import nl.arjanfrans.maze.assets.Assets;
import nl.arjanfrans.maze.game.entities.Decoration;

public class Tile extends Decoration {
    boolean wall = false;

    public Tile(int x, int y, int width, int height, String type) {
        super(x, y, width, height);
        this.createSprite(Assets.getGameTexture(type));
    }

    public boolean isBlocked() {
        return this.wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }

    public boolean isInTile(float x, float y) {
        if(x > this.getX() && x < this.getX() + this.getWidth() && y > this.getY() && y < this.getY() + this.getHeight()) return true;
        return false;
    }

}
