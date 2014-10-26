package nl.arjanfrans.maze.menu.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import nl.arjanfrans.maze.assets.Assets;
import nl.arjanfrans.maze.menu.input.MenuControls;

public class MenuTitle {
    private Label title;

    public MenuTitle(String text) {
        Label.LabelStyle titleStyle = new Label.LabelStyle();
        titleStyle.font = Assets.getFont("visitor2", 64);
        titleStyle.fontColor = Color.YELLOW;
        this.title = new Label(text, titleStyle);
    }

    public Label getTitle() {
        return this.title;
    }
}
