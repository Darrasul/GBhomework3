package homework.seventhLesson;

public class Main {

    public static void main(String[] args) {
        SuperTaskClass firstTask = new TaskOneClass();
        SuperTaskClass secondTask = new TaskTwoClass();

        try {
            firstTask.start(TaskOneClass.class);
            System.out.println("-------------------");
            secondTask.start("TaskTwoClass");
        } catch (ClassNotFoundException e) {
            System.err.println("Fail dont exist");
            e.printStackTrace();
        }
    }
}
