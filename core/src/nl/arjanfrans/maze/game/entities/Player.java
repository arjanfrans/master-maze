package nl.arjanfrans.maze.game.entities;

import nl.arjanfrans.maze.components.input.GameInput;
import nl.arjanfrans.maze.components.input.GameKeys;
import nl.arjanfrans.maze.debug.D;
import nl.arjanfrans.maze.game.map.EventTile;
import nl.arjanfrans.maze.game.map.Map;
import nl.arjanfrans.maze.game.map.Tile;

/**
 * A Player is a controlled character.
 */
public abstract class Player extends Character implements Controllable {
    protected Direction keyPressed = null;
    protected boolean moving = false;
    protected boolean inputEnabled = true;

    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public void setInputEnabled(boolean enabled) {
        this.inputEnabled = enabled;
    }

    public boolean isInputEnabled() {
        return this.inputEnabled;
    }

    @Override
    public void input(Map map) {
        if(GameKeys.isDown(GameKeys.RIGHT)) {
            keyPressed = Direction.RIGHT;
        } else if(GameKeys.isDown(GameKeys.LEFT)) {
            keyPressed = Direction.LEFT;
        } else if(GameKeys.isDown(GameKeys.UP)) {
            keyPressed = Direction.UP;
        } else if(GameKeys.isDown(GameKeys.DOWN)) {
            keyPressed = Direction.DOWN;
        }
        else {
            keyPressed = null;
        }
        this.setDirection(map);
    }

    protected void setDirection(Map map) {
        if(!moving) {
            if(keyPressed == Direction.RIGHT) {
                this.moving = true;
                this.direction = Direction.RIGHT;
            } else if(keyPressed == Direction.LEFT) {
                this.moving = true;
                this.direction = Direction.LEFT;
            } else if(keyPressed == Direction.UP) {
                this.moving = true;
                this.direction = Direction.UP;
            } else if(keyPressed == Direction.DOWN) {
                this.moving = true;
                this.direction = Direction.DOWN;
            }

            if(moving) {
                this.getNextTile(map, (int) this.getX(), (int) this.getY());
            }
        }
    }


    public void move(float delta, Map map) {
        //TODO move this up to moveable entity.
        if(moving) {
            this.checkEvents();
            if(nextTile != null && !nextTile.isBlocked()) {
                float x = this.getX();
                float y = this.getY();
                boolean done = false;
                if(direction == Direction.RIGHT) {
                    x += this.getSpeed() * delta;
                    y = this.getY();
                    done = x >=nextTile.getX();
                } else if(direction == Direction.LEFT) {
                    x += -1 * this.getSpeed() * delta;
                    y = this.getY();
                    done = x <= nextTile.getX();
                } else if(direction == Direction.UP) {
                    x = this.getX();
                    y += this.getSpeed() * delta;
                    done = y >= nextTile.getY();
                } else if(direction == Direction.DOWN) {
                    x = this.getX();
                    y  += -1 * this.getSpeed() * delta;
                    done = y <= nextTile.getY();
                }
                //TODO damping

                if(keyPressed == direction && done) {
                    this.getNextTile(map, (int) this.getX(), (int) this.getY());
                }
                if(keyPressed != direction && done) {
                    x = nextTile.getX();
                    y = nextTile.getY();
                    this.moving = false;
                }
                this.setPosition(x, y);
            }
            else {
                this.moving = false;
                Tile current = this.currentTile(map);
                this.setPosition(current.getX(), current.getY()); // Stay on the grid
            }
        }

    }

    protected void checkEvents() {
        if(this.nextTile instanceof EventTile) {
            ((EventTile) this.nextTile).fireEvent(this);
        }
    }




}
