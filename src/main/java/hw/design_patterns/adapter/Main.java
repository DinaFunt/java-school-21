package hw.design_patterns.adapter;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        ProductHandler productHandler = new ProductHandler();

        Costable product = productRepo.getProduct();
        CostablePricableAdapter adapter = new CostablePricableAdapter(product);

        productHandler.handle(adapter);  //todo fix it
    }
}
