package homework.seventhLesson;

@Test(priority = 2, name = "First")
@Test(priority = 3, name = "Second")
@Test(priority = 4, name = "Third")
@Test(priority = 5, name = "Fourth")
@BeforeSuite(name = "BF")
@AfterSuite(name = "AF")

public class TaskTwoClass implements SuperTaskClass {

    public void start(String className) {
        Class clazz = className.getClass();
        start(clazz);
    }

    public void start(Class clazz) {
        Tests tests = TaskTwoClass.class.getAnnotation(Tests.class);
        BeforeSuite[] bfSuites = TaskTwoClass.class.getAnnotationsByType(BeforeSuite.class);
        AfterSuite[] afSuites = TaskTwoClass.class.getAnnotationsByType(AfterSuite.class);
        int bfsValue = 0;
        int afsValue = 0;


        for (BeforeSuite beforeSuite : bfSuites) {
            bfsValue++;
            if (bfsValue > 1) {
                throw new RuntimeException("Only one BeforeSuite can exist");
            }
            System.out.println(beforeSuite.name() + " in " + clazz.getSimpleName());
        }
        for (int i = 0; i <= 10; i++) {
            for (Test test : tests.value()) {
                if (test.priority() == i){
                    System.out.println(test.name() + " is OK");
                }
            }
        }
        for (AfterSuite afterSuite : afSuites) {
            afsValue++;
            if (afsValue > 1) {
                throw new RuntimeException("Only one AfterSuite can exist");
            }
            System.out.println(afterSuite.name() + " in " + clazz.getSimpleName());
        }
    }
}
