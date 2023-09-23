//abstract nao deixa criar obejtos concretos
public abstract class Item extends GameObject{

    private boolean visible;

    public Item() {
    }

    public Item(int x, int y) {
        super(x, y);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
