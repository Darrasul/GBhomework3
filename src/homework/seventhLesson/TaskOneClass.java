package homework.seventhLesson;

@Test(priority = 5, name = "First")
@Test(priority = 10, name = "Second")
@Test(priority = 5, name = "Third")
@Test(name = "Fourth")
@BeforeSuite(name = "BF")
@AfterSuite(name = "AF")

public class TaskOneClass implements SuperTaskClass {

    public void start(String className) {
        Class clazz = className.getClass();
        start(clazz);
    }

    public void start(Class clazz) {
        Tests tests = TaskOneClass.class.getAnnotation(Tests.class);
        BeforeSuite[] bfSuites = TaskOneClass.class.getAnnotationsByType(BeforeSuite.class);
        AfterSuite[] afSuites = TaskOneClass.class.getAnnotationsByType(AfterSuite.class);

        for (BeforeSuite beforeSuite : bfSuites) {
            if (bfSuites.length > 1) {
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
            if (afSuites.length > 1) {
                throw new RuntimeException("Only one AfterSuite can exist");
            }
            System.out.println(afterSuite.name() + " in " + clazz.getSimpleName());
        }
    }
}
