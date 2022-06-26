import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, 1);
        Stream.iterate(date, d -> d.getMonth() == d.plusDays(1).getMonth(), d -> d.plusDays(1)).filter(d -> d.getDayOfWeek() == DayOfWeek.MONDAY).forEach(System.out::println);
    }
} 