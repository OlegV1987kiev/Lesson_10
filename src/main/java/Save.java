
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Nick on 21.07.2016.
 */
@Retention(value = RetentionPolicy.RUNTIME)//компилятор запишет в class файл и можно использовать reflection
@Target(value = ElementType.FIELD)
public @interface Save {
}