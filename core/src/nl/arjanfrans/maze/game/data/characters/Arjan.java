package nl.arjanfrans.maze.game.data.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import nl.arjanfrans.maze.assets.Assets;
import nl.arjanfrans.maze.game.entities.Player;

public class Arjan extends Player {

    public Arjan(float x, float y) {
        super(x, y, 32, 32);
        this.createSprite(Assets.getGameTexture("player"));

    }


}
