package hw.lab5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss ♥ mm ♥ HH ♥ dd ☺ MM ☺ yyyy");

    public static String convertDateToString(LocalDateTime dateTime) {
        return formatter.format(dateTime);
    }

    public static LocalDateTime convertStringToDate(String dateString) {
        return LocalDateTime.parse(dateString, formatter);
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.convertDateToString(LocalDateTime.now()));
        System.out.println(DateUtils.convertStringToDate("50 ♥ 43 ♥ 15 ♥ 19 ☺ 08 ☺ 2021"));
    }
}
