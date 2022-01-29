package homework.firstLesson;

import homework.firstLesson.fruits.*;

import java.util.ArrayList;
import java.util.List;

public class ThirdTaskMain {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>("appleBox");
        Box<Orange> orangeBox1 = new Box<>("orangeBox1");
        Box<Orange> orangeBox2 = new Box<>("orangeBox2");
        List appleList = new ArrayList();

        for (int i = 0; i < 3; i++) {
            orangeBox1.addFruit(new Orange(), i);
        }
        System.out.println("Вес "+ orangeBox1.getName() + " " + orangeBox1.getBoxWeight());
        for (int i = 0; i < 5; i++) {
            appleBox.addFruit(new Apple(), i);
        }
        System.out.println("Вес "+ appleBox.getName() + " " + appleBox.getBoxWeight());
        System.out.println();

        System.out.println("Вес "+ orangeBox1.getName() + " " + orangeBox1.getBoxWeight());
        System.out.println("Вес "+ orangeBox2.getName() + " " + orangeBox2.getBoxWeight());
        orangeBox1.spillToAnotherBox(orangeBox2);
        System.out.println("Вес "+ orangeBox1.getName() + " " + orangeBox1.getBoxWeight());
        System.out.println("Вес "+ orangeBox2.getName() + " " + orangeBox2.getBoxWeight());
        System.out.println();

        System.out.println("Вес "+ appleBox.getName() + " " + appleBox.getBoxWeight());
        System.out.println("Вес "+ orangeBox2.getName() + " " + orangeBox2.getBoxWeight());
        appleBox.compareBoxes(orangeBox2);

    }
}
