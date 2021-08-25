package hw.design_patterns.adapter;

public class Table implements Costable {
    @Override
    public int cost() {
        return 10;
    }
}
