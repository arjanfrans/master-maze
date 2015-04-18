package nl.arjanfrans.maze.debug;

public class D {

    public static void o(Object msg) {
        if(msg == null) msg = "null";
        System.out.println(msg.toString());
    }
}
