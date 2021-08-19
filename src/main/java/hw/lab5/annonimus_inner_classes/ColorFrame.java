package hw.formats.lab.annonimus_inner_classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFrame extends JFrame {

    public ColorFrame(int counterValue) throws HeadlessException {
        Counter counter = new Counter(counterValue);
        setSize(500,500);
        JButton button = new JButton("click me to be red");


       /* List.of("","sd").sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(counter.increase());

//                03#10#78+12*10 another lab - covert from string to date and visa versa
            }
        });

        getContentPane().add(button, BorderLayout.NORTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static class Counter {
        private int counter;

        public Counter(int counter) {
            this.counter = counter;
        }
        public int increase() {
            return ++counter;
        }
    }
    public static void main(String[] args) {
        new ColorFrame(10);
    }
}
