import java.io.InvalidObjectException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Lesson_10_3 {
    public static void main(String[] args) throws IllegalAccessException {
        final Class<?> cls = TestTest.class;
        TestTest  test = new TestTest ();
        StringBuilder sb=new StringBuilder();
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {


            if (field.isAnnotationPresent(Save.class)) {
                if(Modifier.isPrivate(field.getModifiers())){
                    field.setAccessible(true);
                    sb.append("private ");
                }
                if(Modifier.isPublic(field.getModifiers())){

                    sb.append("public ");
                }
                /*another modifiers*/
                if (!field.getType().equals(String.class)){
                    sb.append(field.getType()).append(" ").append(field.getName()).append("= ");
                }else{
                    sb.append("String ").append(field.getName()).append("= ");
                }

                if (field.getType().equals(int.class)){
                    sb.append(field.getInt(test));
                }
                if (field.getType().equals(long.class)){
                    sb.append(field.getLong(test));
                }
                if (field.getType().equals(double.class)){
                    sb.append(field.getDouble(test));
                }if (field.getType().equals(String.class)){

                    sb.append(field.get(test).toString());

                }
                /*...another types*/
                sb.append("; \n");



            }


        }
        System.out.println(sb.toString());
        String file = "D:\\Lesson_10\\test";
        Serializator sz = new Serializator();
        boolean b = sz.serialization(sb, file);

        StringBuilder deser=null;
        try {
            deser=sz.deserialization(file);
        }catch (InvalidObjectException e) {

            e.printStackTrace();
        }

        System.out.println("Deserialized file \n"+sb.toString());



    }
}
