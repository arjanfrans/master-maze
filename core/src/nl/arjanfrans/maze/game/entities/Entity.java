package nl.arjanfrans.maze.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract class Entity {
    protected float x = 0;
    protected float y = 0;
    protected float width = 0;
    protected float height = 0;
    protected Sprite sprite = null;

    public Entity() {

    }

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Entity(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Get the position as a Vector3 object. Used for camera in renderer.
     * @return
     */
    public Vector3 getVector3Position() {
        return new Vector3(this.getX(), this.getY(), 0);
    }

    public Vector2 getPosition() {
        return new Vector2(this.getX(), this.getY());
    }


    public void setPosition(float x, float y) {
        this.setX(x);
        this.setY(y);
    }

    public float getY() {
        return y;
    }

    public void createSprite(TextureRegion region) {
        Sprite sprite = new Sprite();
        sprite.setRegion(region);
        this.setSprite(sprite);
    }



    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public float getCenterX() {
        return this.x + (this.width / 2);
    }

    public float getCenterY() {
        return this.y + (this.height / 2);
    }
}
