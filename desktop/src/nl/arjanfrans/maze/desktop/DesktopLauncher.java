package nl.arjanfrans.maze.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import nl.arjanfrans.maze.MasterMaze;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 800;
        config.height = 600;
//        packTextures();
		new LwjglApplication(new MasterMaze(), config);
	}

    public static void packTextures() {
        TexturePacker.Settings settings = new TexturePacker.Settings();
        TexturePacker.process(settings, "graphics/sprites", "graphics/spritesheets", "game");
    }
}
