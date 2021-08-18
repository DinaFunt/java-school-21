package hw.lab2;

import lombok.Setter;
import lombok.ToString;

@ToString
public class Client {
    private final int debt;
    private final int bonus;
    private final String name;
    private final int salary;

    private Client(int debt, int bonus, String name, int salary) {
        this.debt = debt;
        this.bonus = bonus;
        this.name = name;
        this.salary = salary;
    }

    @Setter
    public static class ClientBuilder {

        private int bonus;
        private int debt;
        private String name;
        private int salary;

        public Client getResult() {
            return new Client(debt, bonus, name, salary);
        }
    }
}
