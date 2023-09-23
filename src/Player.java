public class Player extends GameObject{

    private Direction direction;
    private int life;
    private boolean invincible;

    public void move(){
        if (direction == Direction.UP) setY(getY()-10);
        if (direction == Direction.DOWN) setY(getY()+10);
        if (direction == Direction.RIGHT) setX(getX()+10);
        if (direction == Direction.LEFT) setX(getX()-10);
    }

    public Player() {
    }

    public Player(int x, int y, Direction direction) {
        super(x, y);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
       if(life>=0) this.life = life;
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }

    public boolean collide(GameObject object) {
      return getY() == object.getY() && getX() == object.getX();
    }

    public void damage() {
        life--;
    }
}
