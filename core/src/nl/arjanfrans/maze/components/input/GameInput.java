package nl.arjanfrans.maze.components.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;


public class GameInput implements InputProcessor {
    public enum Keys {
        RIGHT, LEFT, UP, DOWN
    }
    public static boolean RIGHT = false;
    public static boolean LEFT = false;
    public static boolean UP = false;
    public static boolean DOWN = false;
    public static boolean ARROW_KEY_PRESSED = false;

    @Override
    public boolean keyDown (int keycode) {
        if(keycode == Input.Keys.RIGHT) {
            GameKeys.setKey(GameKeys.RIGHT, true);
            RIGHT = true;
            ARROW_KEY_PRESSED = true;
        }
        if(keycode == Input.Keys.LEFT) {
            GameKeys.setKey(GameKeys.LEFT, true);
            LEFT = true;
            ARROW_KEY_PRESSED = true;
        }
        if(keycode == Input.Keys.UP) {
            GameKeys.setKey(GameKeys.UP, true);
            UP = true;
            ARROW_KEY_PRESSED = true;
        }
        if(keycode == Input.Keys.DOWN) {
            GameKeys.setKey(GameKeys.DOWN, true);
            DOWN = true;
            ARROW_KEY_PRESSED = true;
        }
        if(keycode == Input.Keys.ENTER) {
            GameKeys.setKey(GameKeys.ENTER, true);
        }
        return true;
    }

    @Override
    public boolean keyUp (int keycode) {
        if(keycode == Input.Keys.RIGHT) {
            GameKeys.setKey(GameKeys.RIGHT, false);
            RIGHT = false;
            ARROW_KEY_PRESSED = false;
        }
        if(keycode == Input.Keys.LEFT) {
            GameKeys.setKey(GameKeys.LEFT, false);
            LEFT = false;
            ARROW_KEY_PRESSED = false;
        }
        if(keycode == Input.Keys.UP) {
            GameKeys.setKey(GameKeys.UP, false);
            UP = false;
            ARROW_KEY_PRESSED = false;
        }
        if(keycode == Input.Keys.DOWN) {
            GameKeys.setKey(GameKeys.DOWN, false);
            DOWN = false;
            ARROW_KEY_PRESSED = false;
        }
        if(keycode == Input.Keys.ENTER) {
            GameKeys.setKey(GameKeys.ENTER, false);
        }
        return true;
    }

    @Override
    public boolean keyTyped (char character) {
        return false;
    }

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved (int x, int y) {
        return false;
    }

    @Override
    public boolean scrolled (int amount) {
        return false;
    }
}