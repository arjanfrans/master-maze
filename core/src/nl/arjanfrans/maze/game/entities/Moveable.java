package nl.arjanfrans.maze.game.entities;

import nl.arjanfrans.maze.game.map.Map;

public interface Moveable {

    public void move(float delta, Map map);

    public boolean isStopped();
}
