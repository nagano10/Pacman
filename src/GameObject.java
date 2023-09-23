public class GameObject {

    private int x;
    private int y;
    private int screenSize;


    public GameObject() {
    }

    public GameObject(int x, int y) {
        //DRY Don't Repeat Yourself
            setX(x);
            setY(y);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x>=0 && x <= screenSize) this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y>=0 && y<= screenSize) this.y = y;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        if(screenSize >= 0) this.screenSize = screenSize;
    }
}
