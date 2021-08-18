package hw.lab2;

public class Main {
    public static void main(String[] args) {
//        Client client = new Client(12, 14, "Vasya", 100);

        Client.ClientBuilder cb = new Client.ClientBuilder();
        cb.setDebt(12);
        cb.setBonus(14);
        cb.setName("Vasya");
        cb.setSalary(100);

        Client client = cb.getResult();
    }
}

