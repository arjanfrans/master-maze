package nl.arjanfrans.maze.game.systems.view;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import nl.arjanfrans.maze.assets.Assets;
import nl.arjanfrans.maze.components.input.GameKeys;

public class ControllerButton {
    private ImageButton button;
    private int key;

    /**
     * Button for the controller overlay.
     * @param key The key that it will trigger.
     * @param flipX Flip image horizontally.
     * @param flipY Flip image vertically.
     * @param rotate Rotate 90 degrees.
     */
    public ControllerButton(int key, boolean flipX, boolean flipY, boolean rotate) {
        this.key = key;
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        TextureRegion t = Assets.getGameTexture("controller_button");
        t.flip(flipX, flipY);
        // Rotate 90 degrees (u1 = u1, v1 = v2, u2 = u2, v2 = v1)
        if(rotate) {
            float v2 = t.getV2();
            float v1 = t.getV();
            t.setV(v2);
            t.setV2(v1);
        }

        style.imageUp = new TextureRegionDrawable(t);

        this.button = new ImageButton(style);
        this.button.addListener(new ControllerButtonListener(this));
    }

    public ImageButton getButton() {
        return this.button;
    }


    public int getKey() {
        return this.key;
    }
}
