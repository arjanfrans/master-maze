package nl.arjanfrans.maze.game.maze;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.utils.Array;
import nl.arjanfrans.maze.debug.D;

import java.util.Random;

public class MazeGenerator {
    protected boolean[][] maze;
    protected int width;
    protected int height;
    protected int tileWidth;
    protected int tileHeight;

    protected int x;
    protected int y;
    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;
    protected Array<Integer> moves;
    protected static final int UP = 0;
    protected static final int DOWN = 1;
    protected static final int RIGHT = 2;
    protected static final int LEFT = 3;


    public void generate(int width, int height, int x, int y, int tileWidth, int tileHeight) {
        this.width = 2 * width;
        this.height = 2 * height;

        this.moves = new Array<Integer>();
        this.maze = new boolean[this.width][this.height];
        this.fillMaze();
        this.x = x;
        this.y = y;
        this.startX = x;
        this.startY = y;
        this.createMaze();
        this.print();

    }

    protected void fillMaze() {
        for(int x = 0; x < this.width; x++) {
            for(int y = 0; y < this.height; y++) {
                this.maze[x][y] = true;
            }
        }
        this.maze[x][y] = false;
    }

    protected void createMaze() {
        moves = new Array<Integer>();
        moves.add(y + (x * width));
        while(moves.size > 0) {
            D.o("x " + x);
            D.o("y " + y);
            Array<Integer> possibleDirections = new Array<Integer>();

            if ((x + 2 < height ) && (maze[x + 2][y] == true) && (x + 2 > 0) && (x + 2 < height) )
            {
                possibleDirections.add(DOWN);
            }

            if ((x - 2 >= 0 ) && (maze[x - 2][y] == true) && (x - 2 > 0) && (x - 2 <height) )
            {
                possibleDirections.add(UP);
            }

            if ((y - 2 >= 0 ) && (maze[x][y - 2] == true) && (y - 2 > 0) && (y - 2 < width) )
            {
                possibleDirections.add(LEFT);
            }

            if ((y + 2 < width ) && (maze[x][y + 2] == true) && (y + 2 > 0) && (y + 2 < width ) )
            {
                possibleDirections.add(RIGHT);
            }

            if(possibleDirections.size > 0) {
                int move = possibleDirections.random();
                if(move == RIGHT) {
                    maze[x][y + 2] = false;
                    maze[x][y + 1] = false;
                    y += 2;
                }
                else if(move == LEFT) {
                    maze[x][y - 2] = false;
                    maze[x][y - 1] = false;
                    y -= 2;
                }
                else if(move == UP) {
                    maze[x - 2][y] = false;
                    maze[x - 1][y] = false;
                    x -= 2;
                }
                else if(move == DOWN) {
                    maze[x + 2][y] = false;
                    maze[x + 1][y] = false;
                    x += 2;
                }
                moves.add(y + (x * width));
            }
            else {
                int back = moves.pop();
                x = MathUtils.floor(back / width);
                y = back % (width);
                this.endX = x;
                this.endY = y;

            }
        }


    }

    public void print() {
        for(int y = 0; y < height; y++) {
            String row = "";
            for(int x = 0; x < width; x++) {
                if(false && x == this.endX && y == this.endY) row = row + "E";
                else if(x == this.startX && y == this.startY) row = row + "S";
                else row = row + (maze[x][y] == true ? "X" : "@");
            }
            System.out.println(row);
        }
    }


}
