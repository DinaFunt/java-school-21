package hw.my_spring;

import hw.my_spring.annotations.InjectRandomInt;

public class CleanerImpl implements Cleaner {

    @InjectRandomInt(min = 3, max = 20)
    private int repeat;


    public CleanerImpl() {
        System.out.println("repeat = " + repeat);
    }

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVvvvvvvvvvvvvvvvvv");
        }
    }
}
