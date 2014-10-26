package nl.arjanfrans.maze.game.events;

import nl.arjanfrans.maze.debug.D;
import nl.arjanfrans.maze.game.data.World;
import nl.arjanfrans.maze.game.entities.Entity;
import nl.arjanfrans.maze.game.stats.Stats;
import nl.arjanfrans.maze.utils.Timer;

public class StartLevel extends TimerEvent {

    public StartLevel() {
        super(2);
    }

    @Override
    protected void before(World world) {
        //TODO play start sound
    }

    @Override
    protected void finished(World world) {
        world.start();
    }

}
