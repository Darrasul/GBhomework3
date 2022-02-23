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

