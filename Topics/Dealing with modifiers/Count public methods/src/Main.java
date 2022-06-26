import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

class ReflectionUtils {

    public static int countPublicMethods(Class targetClass) {
        int counter;
        Method[] methods = targetClass.getDeclaredMethods();
        counter = (int) Arrays.stream(methods).mapToInt(Method::getModifiers).filter(Modifier::isPublic).count();
        return counter;
    }
}