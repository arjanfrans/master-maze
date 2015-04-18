package nl.arjanfrans.maze.game.map;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;

public class Layer {
    protected String name;

    protected int cols;

    protected int rows;

    protected int tileWidth;

    protected int tileHeight;
    protected ArrayMap<Integer, Tile> tiles;


    public Layer(String name, int cols, int rows, int tileWidth, int tileHeight) {
        this.name = name;
        this.cols = cols;
        this.rows = rows;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.tiles = new ArrayMap<Integer, Tile>(true, this.cols * this.rows);
    }

    public void setTiles(ArrayMap<Integer, Tile> tiles) {
        this.tiles = tiles;
    }


    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }


    /**
     * Add a tile to the map, if a tile already exists it will be overwritten.
     * @param tile
     */
    public void addTile(Tile tile) {
        int index = this.getTileIndex((int) tile.getX(), (int) tile.getY());
        this.tiles.put(index, tile);
    }

    protected int getTileIndexFromGrid(int x, int y) {
        return (getTileX(x) / this.getTileWidth()) + (getTileY(y) / this.getTileHeight() * this.cols);
    }

    protected int getTileIndex(int x, int y) {
        return (x / this.getTileWidth()) + (y / this.getTileHeight() * this.cols);
    }

    protected int getTileX(int cell) {
        return (cell % this.cols) * this.getTileWidth();
    }

    protected int getTileY(int cell) {
        return (cell / this.cols) * this.getTileHeight();
    }

    public Tile getTileFromGrid(float x, float y) {
        if(x >= this.getWidth() || y >= this.getHeight() || x < 0 || y < 0) return null;
        int nx = (int) Math.floor(x / this.tileWidth) * this.tileWidth;
        int ny = (int) Math.floor(y / this.tileHeight) * this.tileHeight;
        return tiles.get(getTileIndex(nx, ny));
    }

    public Tile getTile(int x, int y) {
        if(x > this.getWidth() || y > this.getHeight() || x < 0 || y < 0) return null;
        return tiles.get(this.getTileIndex(x, y));
    }

    public Array<Tile> getTilesInBounds(Rectangle bounds) {
        Array<Tile> t = new Array<Tile>();

        for(int x = (int) bounds.x; x < (int) bounds.x + bounds.width; x += this.getTileWidth()) {
            for(int y = (int) bounds.y; y < (int) bounds.y + bounds.height; y += this.getTileHeight()) {
                Tile tile = this.getTile(x, y);
                if(tile != null) t.add(tile);
            }
        }
        return t;
    }

    public boolean isTileBlocked(int x, int y) {
        Tile tile = this.getTile(x, y);
        return tile == null ? false : tile.isBlocked();
    }

    public Array<Tile> getTiles() {
        return this.tiles.values().toArray();
    }

    public int getWidth() {
        return (this.cols) * this.getTileWidth();
    }

    public int getHeight() {
        return (this.rows) * this.getTileHeight();
    }
    
    public int getTileWidth() {
        return this.tileWidth;
    }
    
    public int getTileHeight() {
        return this.tileHeight;
    }

    public String getName() {
        return this.name;
    }
}
