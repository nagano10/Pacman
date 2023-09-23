public class Booster extends Item{

    private int duration;

    public Booster() {
    }

    public Booster(int x, int y, int duration) {
        super(x, y);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
       if(duration>=0) this.duration = duration;
    }
}
