package nl.arjanfrans.maze.game.systems.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import nl.arjanfrans.maze.assets.Assets;

public class HudLabel {
    private Label label;

    public HudLabel(String text) {
        Label.LabelStyle titleStyle = new Label.LabelStyle();
        titleStyle.font = Assets.getFont("visitor2", 42);
        titleStyle.fontColor = Color.YELLOW;
        this.label = new Label(text, titleStyle);
    }

    public void setText(String text) {
        this.label.setText(text);
    }

    public Label getLabel() {
        return this.label;
    }
}
