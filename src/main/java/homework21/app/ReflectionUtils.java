package homework21.app;

import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void getAnnotationInfo(Class<?> clazz){

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MethodInfo.class)){
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                System.out.println("Method name: " + methodInfo.name());
                System.out.println("Method return type: " + methodInfo.returnType());
                System.out.println("Method description: " + methodInfo.description());
            }
            System.out.println();

            if (method.isAnnotationPresent(Author.class)){
                Author author = method.getAnnotation(Author.class);
                System.out.println("Author name: " + author.name());
                System.out.println("Author surname: " + author.surname());
            }
            System.out.println();
        }
    }

}
