import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.
 */

public class Main {
    public static void main(String[] args) {

        String str = "";
        //getMethods(str);

        Class<?> testClass = String.class;
        getMethods(testClass);
        System.out.println("=========================================================================");
        getConstructors(testClass);
        System.out.println("=========================================================================");
        getFields(testClass);


    }

    private static void getMethods(Class str){
        Method[] methods = str.getClass().getDeclaredMethods();
        // getCalss если используем обычную строку str, тогда входной параметр в Метод String str

        for(Method method : methods){
            System.out.println(method);
        }
    }

    private static void getConstructors(Class str){
        Constructor[] constructors = str.getConstructors();

        for(Constructor constructor : constructors){
            System.out.println(constructor);
        }
    }

    private static void getFields(Class str){
        Field[] fields = str.getFields();

        for(Field field : fields){
            System.out.println(field);
        }
    }
}
