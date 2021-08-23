package hw.lab6;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ListUtils {
    public static <T> void forEachWithDelay (List<T> list, int delay, Consumer<T> consumer) {
        for (T item : list) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            consumer.accept(item);
        }
    }

    public static <T> int countDuplicate(T value, List<T> list) {
        return Collections.frequency(list, value);
    }


    public static <T> int countDuplicate(T value, List<T> list, Equalator<T> equalator) {

        int counter = 0;

        for (T t : list) {
            if (equalator.equals(t, value)) {
                counter++;
            }

        }
        return counter;
    }
}
