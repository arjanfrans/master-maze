package nl.arjanfrans.maze.game.systems.view;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import nl.arjanfrans.maze.components.input.GameKeys;

public class ControllerButtonListener extends ClickListener {
    private ControllerButton button;

    public ControllerButtonListener(ControllerButton button) {
        this.button = button;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        GameKeys.setKey(this.button.getKey(), true);
        return true;
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        GameKeys.setKey(this.button.getKey(), false);
    }
}
