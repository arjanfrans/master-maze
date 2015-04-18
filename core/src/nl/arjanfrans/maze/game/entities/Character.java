package nl.arjanfrans.maze.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

/**
 * A character is a visible and movable entity.
 */
public abstract class Character extends MoveableEntity implements Drawable {

    public Character(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public void draw(SpriteBatch batch) {
        if(sprite != null) batch.draw(this.getSprite(), this.getX(), this.getY());
    }




}
