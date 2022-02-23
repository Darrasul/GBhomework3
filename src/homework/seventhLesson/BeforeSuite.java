package homework.seventhLesson;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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

