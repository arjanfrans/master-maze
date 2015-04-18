package nl.arjanfrans.maze.game.data.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import nl.arjanfrans.maze.assets.Assets;
import nl.arjanfrans.maze.game.entities.Player;
import nl.arjanfrans.maze.game.map.Map;

public class Arjan extends Player {

    public Arjan(float x, float y, Map map) {
        super(x, y, 32, 32, map);
        this.createSprite(Assets.getGameTexture("player"));

    }


}
