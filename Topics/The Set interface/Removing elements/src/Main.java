import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        String[] input = str.split(" ");
        Set<Integer> output = new HashSet<>();
        for (String number : input) {
            output.add(Integer.parseInt(number));
        }
        return output;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        // write your code here
        set.removeIf(num -> num > 10);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}