package lessons.lesson1.generic;

import java.time.LocalDate;

public class TestGeneric {

    public static void main(String[] args) {

        GenericStorage<String> stringStorage = new GenericStorageImpl<>(5);
        stringStorage.add("first");
        stringStorage.add("second");
        stringStorage.display();
        System.out.println();

        LocalDate now = LocalDate.now();
        now.getDayOfMonth();

        GenericStorage<LocalDate> dateStorage = new GenericStorageImpl<>(5);
        dateStorage.add(LocalDate.parse("2020-01-01"));
        dateStorage.add(LocalDate.parse("2021-01-01"));
        dateStorage.add(LocalDate.parse("2022-01-01"));
        dateStorage.display();
        System.out.println();

        LocalDate valueLeft = dateStorage.min().getValueLeft();
        System.out.println("ValueLeft = " + valueLeft);
        System.out.println();
    }


}
