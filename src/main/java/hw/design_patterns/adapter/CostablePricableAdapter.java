package hw.design_patterns.adapter;

public class CostablePricableAdapter implements Pricable {

    private final Costable costable;
    public CostablePricableAdapter (Costable costable) {
        this.costable = costable;
    }

    @Override
    public int getPrice() {
        return costable.cost();
    }
}
