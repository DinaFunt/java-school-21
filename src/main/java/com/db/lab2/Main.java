package com.db.lab2;

public class Main {
    public static void main(String[] args) {
//        Client client = new Client(12, 14, "Vasya", 100);

        ClientBuilder cb = new ClientBuilder();
        cb.setDebt(12);
        cb.setSalary(14);
        cb.setName("Vasya");
        cb.setBonus(100);

        Client client = cb.getResult();
    }
}

