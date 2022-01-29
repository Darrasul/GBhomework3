package homework.firstLesson;

public class SwitchElements<E> {

    private E[] elements;
    private int currentSize;

    public SwitchElements(int size) {
        this.elements = (E[]) new Object[size];
    }

    public E[] switchBetween(int firstElement, int secondElement){
        E firstToSwitch = elements[firstElement];
        E secondToSwitch = elements[secondElement];
        elements[firstElement] = secondToSwitch;
        elements[secondElement] = firstToSwitch;
        return elements;
    }

    public void showAllElements(){
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }

    public E get(int index) {
        return elements[index];
    }

    public void add(E element) {
        add(element, currentSize);
    }

    public void add(E element, int index){
        elements[index] = element;
        currentSize++;
    }

    public void remove(int index) {
        elements[index] = null;
        currentSize--;
    }

    public static void main(String[] args) {
        SwitchElements<String> switchedArray = new SwitchElements<>(5);
        switchedArray.add("first");
        switchedArray.add("second");
        switchedArray.add("third");
        switchedArray.add("fourth");
        switchedArray.add("fifth");
        switchedArray.showAllElements();
        System.out.println();
        switchedArray.switchBetween(0, 1);
        switchedArray.showAllElements();
        System.out.println();
        switchedArray.switchBetween(2, 4);
        switchedArray.showAllElements();
        System.out.println();
    }
}
