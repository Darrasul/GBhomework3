package homework.firstLesson;

import java.util.*;

public class TransformToArrayList<E> {

    private E[] arrayToTransform;
    private int currentSize;

    public TransformToArrayList(int size) {
        this.arrayToTransform = (E[]) new Object[size];
    }

    public void add(E element) {
        add(element, currentSize);
    }

    public void add(E element, int index){
        arrayToTransform[index] = element;
        currentSize++;
    }

    public void remove(int index) {
        arrayToTransform[index] = null;
        currentSize--;
    }

    public void showAllElements(){
        for (int i = 0; i < arrayToTransform.length; i++) {
            System.out.println(arrayToTransform[i]);
        }
    }

    public ArrayList<E> transformIntoArrayList() {
        ArrayList<E> result = new ArrayList<>();
        for (int i = 0; i < arrayToTransform.length; i++) {
            result.add(i, (E) arrayToTransform[i]);
        }
        return result;
    }

    public void showAllArrayListElements() {
        for (E element : arrayToTransform) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        TransformToArrayList<Integer> transformedArray = new TransformToArrayList<>(5);
        transformedArray.add(1);
        transformedArray.add(2);
        transformedArray.add(3);
        transformedArray.add(4);
        transformedArray.add(5);
        transformedArray.showAllElements();
        System.out.println();

        transformedArray.transformIntoArrayList();
        transformedArray.showAllArrayListElements();
    }
}
