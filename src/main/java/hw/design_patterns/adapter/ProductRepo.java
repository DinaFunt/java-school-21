package hw.design_patterns.adapter;

import hw.lab3.utils.RandomUtil;

import java.util.List;
import java.util.function.Supplier;

public class ProductRepo {

    private List<Supplier<? extends Costable>> products = List.of(Chair::new,Table::new);

    public Costable getProduct() {
        return RandomUtil.getRandomElement(products).get();
    }
}
