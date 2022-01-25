package lessons.lesson1.common;

public class TestStorage {

    public static void main(String[] args) {
        CommonStorage intStorage = new CommonStorage(5);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.display();
        System.out.println();

        Integer o1 = (Integer) intStorage.get(0);
        Object o2 = intStorage.get(1);
        if (o2 instanceof String){
            o2 = Integer.parseInt((String) o2);
        } else {
            o2 = (Integer) intStorage.get(1);
        }
//        System.out.println(o1 + o2);
//          Уже не выходит, т.к. все идет не по плану
        System.out.println();

        StringStorage stringStorage = new StringStorage(5);
        stringStorage.add("First");
        stringStorage.add("Second");
        stringStorage.display();
        System.out.println();

    }
}
