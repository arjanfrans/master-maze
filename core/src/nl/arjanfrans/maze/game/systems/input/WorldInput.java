package nl.arjanfrans.maze.game.systems.input;

import nl.arjanfrans.maze.components.SystemInterface;
import nl.arjanfrans.maze.components.input.GameKeys;
import nl.arjanfrans.maze.debug.D;
import nl.arjanfrans.maze.game.data.World;
import nl.arjanfrans.maze.game.entities.Controllable;

import java.util.Iterator;

public class WorldInput implements SystemInterface {
    protected World world;

    public WorldInput(World world) {
        this.world = world;
    }

    public void update(float delta) {
        for(Controllable c : world.getControllables()) {
            if(c.isInputEnabled()) c.input();
        }
    }
}
