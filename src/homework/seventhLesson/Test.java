package homework.seventhLesson;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Repeatable(Tests.class)
public @interface Test {
    int priority() default 1;
    String name();
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Tests {
    Test[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Repeatable(BFSuite.class)
@interface BeforeSuite {
    String name();
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface BFSuite {
    BeforeSuite[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Repeatable(AFSuite.class)
@interface AfterSuite {
    String name();
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface AFSuite {
    AfterSuite[] value();
}
