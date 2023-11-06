
public class Toy {
    private int id;
    private String name;
    private int rate;

    public Toy(int id,  int rate, String name ) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }
    public int getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return  id + " " + rate + " " + name;
    }
}
