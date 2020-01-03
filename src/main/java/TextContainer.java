import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
@interface SaveTo {

    String path();
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface Saver {
}

@SaveTo(path = "D:\\Lesson_10\\test")
public class TextContainer {

    private static final String TEXT = "This is SPARTAaa!";

    @Saver
    public static void save(String path) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(TEXT);
            System.out.println("Saving: DONE");
        } catch (IOException ex) {
            System.out.println("Saving: ERROR - " + ex.getMessage());
        }
    }
}
