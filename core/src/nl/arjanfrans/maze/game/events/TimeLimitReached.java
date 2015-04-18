package nl.arjanfrans.maze.game.events;

import nl.arjanfrans.maze.MasterMaze;
import nl.arjanfrans.maze.game.data.World;
import nl.arjanfrans.maze.screens.MainMenuScreen;
import nl.arjanfrans.maze.utils.Timer;

public class TimeLimitReached extends TimerEvent {
    private MasterMaze game;

    public TimeLimitReached(MasterMaze game) {
        super(2);
    }

    @Override
    protected void before(World world) {
        //TODO play sound
        world.setStop(true);
        world.getPlayer().setInputEnabled(false);
    }

    @Override
    protected void finished(World world) {
        game.setScreen(new MainMenuScreen(game));
    }
}
