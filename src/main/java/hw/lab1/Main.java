package hw.lab1;

public class Main {

    static public void main(String[] args) {
        SuperIntegerList list1 = new MySuperIntegerList();
        list1.add(1);
        list1.add(2);
        list1.add(16);
        list1.add(2);
        list1.add(2);
        list1.printAll();

        try {
            list1.removeByIndex(2);
            list1.printAll();

            list1.removeByValue(2);
            list1.printAll();

            System.out.println(list1.get(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
