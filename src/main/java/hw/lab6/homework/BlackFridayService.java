package hw.lab6.homework;


import hw.lab6.employees.Employee;
import hw.lab6.employees.Seniority;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlackFridayService {

    public static void printBlackFridayPerYearSorted(int startYear, int endYear) {

        LocalDate startDate = LocalDate.of(startYear, 1, 13);
        LocalDate endDate = LocalDate.of(endYear, 1, 13);
        long monthCount = ChronoUnit.MONTHS.between(startDate, endDate);


        Map<Integer, Long> results = Stream.iterate(startDate, date -> date.plusMonths(1))
                .limit(monthCount)
                .filter(curDate -> curDate.getDayOfWeek() == DayOfWeek.FRIDAY)
                .collect(Collectors.groupingBy(LocalDate::getYear, Collectors.counting()));

        results.entrySet().stream().
                sorted(Comparator.comparing(Map.Entry<Integer, Long>::getValue).
                        thenComparing(Map.Entry::getKey).reversed())
                .forEach(System.out::println);
//        IntStream.range(startYear,endYear)

//        Stream.iterate(startDate,date ->date.plusDay() )

//        Stream.generate()

        // 1972 - 3
        // 1984 - 3
        // 1986 - 3
        // 1902 - 3
        // 1901 - 2
        // 1917 - 2
        // 1915 - 2
        // 1911 - 1
    }
}
