package nl.arjanfrans.maze.game.events;

import nl.arjanfrans.maze.game.data.World;
import nl.arjanfrans.maze.game.entities.Entity;

public interface Event {

    /**
     * Returns true if event is handled, otherwise false.
     * @param world
     * @return
     */
    public boolean handle(World world);

    public void fire();
}
