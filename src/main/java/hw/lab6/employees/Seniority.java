package hw.lab6.employees;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum Seniority {

    JUN(Integer.MIN_VALUE, 10),
    MIDDLE(11, 20),
    SENIOR(21, Integer.MAX_VALUE);

    private final int min;
    private final int max;


    public static Seniority getSeniorityBySalary(int salary) {
        return Arrays.stream(values())
                .filter(seniority -> seniority.min <= salary)
                .filter(seniority -> seniority.max >= salary)
                .findAny()
                .get();
    }
}
