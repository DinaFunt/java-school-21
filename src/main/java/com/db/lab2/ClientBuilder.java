package com.db.lab2;

import lombok.Setter;

@Setter
public class ClientBuilder {

    private int bonus;
    private int debt;
    private String name;
    private int salary;

    public Client getResult() {
        return new Client(debt, bonus, name, salary);
    }
}
