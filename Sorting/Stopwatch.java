class Stopwatch {
    private long startTime;
    private long endTime;

    Stopwatch() {
        startTime = 0;
        endTime = 0;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getTime() {
        return endTime - startTime;
    }
}
