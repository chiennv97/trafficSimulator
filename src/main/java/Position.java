public class Position {
    int x;
    int xStop;
    boolean count;

    public Position(int x, int xStop, boolean count) {
        this.x = x;
        this.xStop = xStop;
        this.count = count;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getxStop() {
        return xStop;
    }

    public void setxStop(int xStop) {
        this.xStop = xStop;
    }
}
