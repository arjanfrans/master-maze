package nl.arjanfrans.maze.game.entities;

import nl.arjanfrans.maze.game.map.Map;

public interface Controllable {

    public void input(Map map);

    public boolean isInputEnabled();
}
