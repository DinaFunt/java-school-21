package hw.lab6.employees;

import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SongUtils {
    private static final String songPath = "D://Dina//java-school//data//song.txt";

    @SneakyThrows
    public static long countWords() {

        long result = -1;
        Path path  = Paths.get(songPath);
        List<String> list = new ArrayList<>();


        try (Stream<String> stream = Files.lines(path)) {

//            result = stream.flatMap(line -> Arrays.stream(line.split("\\W+"))).count();
            list = stream.flatMap(line -> Arrays.stream(line.split("\\W+"))).collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countWords());
    }
}
