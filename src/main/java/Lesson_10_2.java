
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Lesson_10_2 {

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        TextContainer container = new TextContainer();
        Class<?> cls = container.getClass();

        SaveTo annSaveTo = cls.getAnnotation(SaveTo.class);

        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                method.invoke(container, annSaveTo.path());
            }
        }
    }
}
