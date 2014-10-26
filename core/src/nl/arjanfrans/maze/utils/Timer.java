package nl.arjanfrans.maze.utils;

import com.badlogic.gdx.utils.TimeUtils;
import nl.arjanfrans.maze.debug.D;

public class Timer {
    private long startTime = 0;
    private long endTime = Long.MAX_VALUE;
    private long duration = Long.MAX_VALUE;
    private long pauseTime = 0;
    private long resumeTime = 0;
    private boolean stopped = true;
    private boolean started = false;

    public Timer() {}

    public Timer(long duration) {
        this.setDuration(duration);
    }

    public void start() {
        this.started = true;
        this.stopped = false;
        this.startTime = TimeUtils.nanoTime();
    }

    public void stop() {
        this.stopped = true;
        this.endTime = TimeUtils.nanoTime();
    }

    public void pause() {
        this.pauseTime = TimeUtils.nanoTime();
    }

    public void resume() {
        this.resumeTime = TimeUtils.nanoTime();
    }

    protected long pauseDuration() {
        return this.resumeTime - this.pauseTime;
    }

    public long getStopTime(boolean seconds) {
        long time = endTime - startTime - this.pauseDuration();
        return seconds ? this.nanosToSeconds(time) : time;
    }

    public boolean isFinished() {
        if(TimeUtils.nanoTime() - (startTime + this.pauseDuration()) >= this.duration) return true;
        return false;
    }

    public long getElapsedSeconds() {
        return this.nanosToSeconds(TimeUtils.nanoTime() - this.pauseDuration() - startTime);
    }

    public static long nanosToSeconds(long nanos) {
        return nanos / 1000000000;
    }

    public static long secondsToNanos(long seconds) {
        return seconds * 1000000000;
    }

    public long getRemainingEndTime() {
        return this.nanosToSeconds(Math.abs(startTime  + duration - endTime - this.pauseDuration()));
    }

    public long getRemainingTime() {
        if(!started) return this.nanosToSeconds(duration);
        return this.nanosToSeconds(Math.abs(startTime  + duration - (stopped ? endTime : TimeUtils.nanoTime()) - this.pauseDuration()));
    }

    public void setDuration(long duration) {
        this.duration = secondsToNanos(duration);
    }
}
