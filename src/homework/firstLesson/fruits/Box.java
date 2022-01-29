package homework.firstLesson.fruits;

import java.util.*;

public class Box<F extends Fruit> implements Comparable<Box> {

    ArrayList<F> box = new ArrayList<>();
    Double boxWeight = 0.0;
    String name;
    int currentSize = 0;

    public Box(String name) {
        this.name = name;
    }

    public void addFruit(F fruit){
        boxWeight += fruit.getWeight();
        box.add(currentSize ,fruit);
        currentSize++;
    }

    public void addFruit(F fruit, int index){
        boxWeight += fruit.getWeight();
        box.add(index, fruit);
        currentSize++;
    }

    public void removeFruit(F fruit){
        boxWeight -= fruit.getWeight();
        box.remove(fruit);
        currentSize--;
    }

    public void showAmount(){
        System.out.println(currentSize);
    }

    public String getName() {
        return name;
    }

    public Double getBoxWeight(){
        return boxWeight;
    }

    public void spillToAnotherBox (Box<F> anotherBox){
        for (F fruit : box) {
            anotherBox.addFruit(fruit);
        }
        box.subList(0,currentSize).clear();

        this.boxWeight = 0.0;
    }

    public void compareBoxes(Box anotherBox){

        if (compareTo(anotherBox) == 1){
            System.out.println(this.name + " больше " + anotherBox.name);
        } else if (compareTo(anotherBox) == -1) {
            System.out.println(this.name + " меньше " + anotherBox.name);
        } else if (compareTo(anotherBox) == 0) {
            System.out.println("Коробки равны");
        } else {
            System.out.println("Не удалось сопоставить");
        }
    }

    @Override
    public int compareTo(Box anotherBox) {
        if (this.getBoxWeight() > anotherBox.boxWeight){
            return 1;
        } else if (this.getBoxWeight() < anotherBox.getBoxWeight()){
            return -1;
        } else {
            return 0;
        }
    }
}
