package nl.arjanfrans.maze.debug;

import com.badlogic.gdx.utils.TimeUtils;
import nl.arjanfrans.maze.Config;

import java.util.concurrent.TimeUnit;

public class FPS {
    public static boolean output = false;
    private static long lastRender;
    private static long now;
    private static int frameCount = 0;
    private static int lastFPS = 0;

    private final static int FPSupdateIntervall = 1;  //--- display FPS alle x sekunden
    private final static int logic_FPSupdateIntervall = 1;  //--- display FPS alle x sekunden
    private static long logic_lastRender;
    private static long logic_now;
    private static int logic_frameCount = 0;
    private static int logic_lastFPS = 0;

    public static void preCheck() {
        frameCount++;
        now = TimeUtils.nanoTime();

        if((now - lastRender) >= FPSupdateIntervall * 1000000000) {

            lastFPS = frameCount / FPSupdateIntervall;

            frameCount = 0;
            lastRender = System.nanoTime();
        }
    }

    public static void postCheck() {
        logic_frameCount ++;
        logic_now = TimeUtils.nanoTime();	// zeit loggen

        if ((logic_now - logic_lastRender) >= logic_FPSupdateIntervall * 1000000000)  {
            logic_lastFPS = logic_frameCount / logic_FPSupdateIntervall;
            logic_frameCount = 0;
            logic_lastRender = TimeUtils.nanoTime();
            if(Config.SHOW_FPS) D.o("FPS: " + logic_lastFPS);
        }
    }
}
