package hw.lab1;

import java.util.Arrays;

public class MySuperIntegerList implements SuperIntegerList {
    private int[] numbers;
    private int arrayLength;
    private int length;
    private static final int START_ARRAY_SIZE = 5;

    public MySuperIntegerList() {
        numbers = new int[START_ARRAY_SIZE];
        length = START_ARRAY_SIZE;
        arrayLength = 0;
    }

    @Override
    public void add(int number) {
        if (arrayLength == length - 1) {
            length *= 2;
            numbers = Arrays.copyOf(numbers, length);
        }
        numbers[arrayLength++] = number;
    }

    @Override
    public void removeByIndex(int index) {
        if (index >= arrayLength || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.arraycopy(numbers, index + 1, numbers, index, arrayLength - index);
        arrayLength--;
    }

    @Override
    public void removeByValue(int value) {
        for (int i = arrayLength - 1 ; i >= 0; i--) {
            if (numbers[i] == value) {
                this.removeByIndex(i);
            }
        }
    }

    @Override
    public int get(int index) {
        if (index >= arrayLength - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return numbers[index];
    }

    @Override
    public void printAll() {
        for (int i = 0; i < arrayLength - 1; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println(numbers[arrayLength - 1]);
    }
}
