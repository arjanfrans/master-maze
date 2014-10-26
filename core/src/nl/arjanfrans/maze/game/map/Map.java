package nl.arjanfrans.maze.game.map;


import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;

public class Map {
    protected int cols = 0;
    protected int rows = 0;
    protected int width = 0;
    protected int height = 0;

    protected ArrayMap<String, Layer> layers = new ArrayMap<String, Layer>();

    /**
     * Add a layer to the map.
     * @param name
     * @param layer
     */
    public void addLayer(String name, Layer layer) {
        this.updateProperties(layer);
        this.layers.put(name, layer);
    }

    /**
     * Update the size of this map according to the newly added layer.
     * @param layer
     */
    protected void updateProperties(Layer layer) {
        this.width = layer.getWidth() > this.width ? layer.getWidth() : this.width;
        this.height = layer.getHeight() > this.height ? layer.getHeight() : this.height;
        this.cols = layer.getCols() > this.cols ? layer.getCols() : this.cols;
        this.rows = layer.getRows() > this.rows ? layer.getRows() : this.rows;
    }

    /**
     * Get all tiles, from all layers.
     * @return
     */
    public Array<Tile> getAllTiles() {
        Array<Tile> tiles = new Array<Tile>();
        for(Layer layer : layers.values()) {
            tiles.addAll(layer.getTiles());
        }
        return tiles;
    }

    /**
     * Get a layer from the map.
     * @param name
     * @return
     */
    public Layer getLayer(String name) {
        return this.layers.get(name);
    }

    public int getWidths() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

}
