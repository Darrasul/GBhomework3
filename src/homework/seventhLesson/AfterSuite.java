package homework.seventhLesson;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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