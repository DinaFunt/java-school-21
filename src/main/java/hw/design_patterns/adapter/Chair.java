package hw.design_patterns.adapter;

public class Chair implements Costable {
    @Override
    public int cost() {
        return 5;
    }
}
