package nl.arjanfrans.maze.game.data;

import com.badlogic.gdx.math.MathUtils;
import nl.arjanfrans.maze.assets.Assets;
import nl.arjanfrans.maze.game.data.characters.Arjan;
import nl.arjanfrans.maze.game.events.NextLevel;
import nl.arjanfrans.maze.game.events.StartLevel;
import nl.arjanfrans.maze.game.map.EventTile;
import nl.arjanfrans.maze.game.map.Layer;
import nl.arjanfrans.maze.game.map.Map;
import nl.arjanfrans.maze.game.map.Tile;
import nl.arjanfrans.maze.game.stats.Stats;
import nl.arjanfrans.maze.game.systems.events.EventHandler;

/**
 * Generate the game data for the world. This class contains specific info, like position of player and sprites.
 */

public class WorldGenerator {
    protected World world;

    public WorldGenerator(World world) {
        this.world = world;
    }

    public void generate() {
        this.loadAssets();
        this.createMap();
        this.startWorld();
    }

    protected void startWorld() {
        //TODO get time limit based of maze difficulty
        this.world.setTimeLimit(6);
        new StartLevel().fire();
    }

    protected void loadAssets() {
        Assets.load();
    }

    protected void createPlayer(Map map) {
        Arjan player = new Arjan(128f, 32f, map);
        player.setInputEnabled(false);
        this.world.addEntity(player);
    }

    protected Map createMap() {
        Map map = new Map();
        createPlayer(map);
        Layer grass = new Layer("grass", 16, 16, 32, 32);
        this.generateGrassLayer(grass);
        map.addLayer("grass", grass);
        this.world.setMap(map);

        for(Tile tile : map.getAllTiles()) {
            this.world.addEntity(tile);
        }
        return map;
    }

    //TODO create a real map generator
    protected void generateGrassLayer(Layer layer) {
        for(int x = 0; x < layer.getCols(); x++) {
            for (int y = 0; y < layer.getRows(); y++) {
                if(x == layer.getCols() - 1 && y == layer.getRows() - 1) {
                    EventTile tile = new EventTile(x * layer.getTileWidth(), y * layer.getTileHeight(), layer.getTileWidth(), layer.getTileHeight(), "ending");
                    tile.setEvent(new NextLevel());
                    layer.addTile(tile);
                }
                else if((x != world.getPlayer().getX() && y != world.getPlayer().getY()) && (x == MathUtils.random(x, x + 3) && y == MathUtils.random(y, y + 1))) {
                    Tile t = new Tile(x * layer.getTileWidth(), y * layer.getTileHeight(), layer.getTileWidth(), layer.getTileHeight(), "wall");
                    t.setWall(true);
                    layer.addTile(t);
                }
                else {
                    layer.addTile(new Tile(x * layer.getTileWidth(), y * layer.getTileHeight(), layer.getTileWidth(), layer.getTileHeight(), "grass"));
                }
            }
        }
    }

}
