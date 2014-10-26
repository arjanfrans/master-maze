package nl.arjanfrans.maze.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Decoration extends Entity implements Drawable {

    public Decoration(float x, float y, float width, float height) {
        super(x, y, width, height);
    }
    public void draw(SpriteBatch batch) {
        //TODO same code as Character class, find some way to make more abstract
        if(sprite != null) batch.draw(this.getSprite(), this.getX(), this.getY());
    }
}
