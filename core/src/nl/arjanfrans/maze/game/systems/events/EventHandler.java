package nl.arjanfrans.maze.game.systems.events;

import com.badlogic.gdx.utils.Array;
import nl.arjanfrans.maze.components.SystemInterface;
import nl.arjanfrans.maze.game.data.World;
import nl.arjanfrans.maze.game.events.Event;

import java.util.Iterator;

public class EventHandler implements SystemInterface {
    protected World world;
    public static Array<Event> events = new Array<Event>();
    protected Iterator<Event> eventsIterator;

    public EventHandler(World world) {
        this.world = world;
    }

    @Override
    public void update(float delta) {
        for(Event event : events) {
            if(event.handle(this.world)) events.removeValue(event, true);
        }
    }
}
