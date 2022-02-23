package homework.seventhLesson;

public class Main {

    public static void main(String[] args) {
        SuperTaskClass firstTask = new TaskOneClass();
        SuperTaskClass secondTask = new TaskTwoClass();

        firstTask.start(TaskOneClass.class);
        System.out.println("-------------------");
        secondTask.start("TaskTwoClass");

    }
}
