import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;

/**
 * Напишите программу, которая использует Stream API
 * для обработки списка чисел. Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers1 = new ArrayList<>();
        for (int i = 1; i <= 14; i = i + 1) {
            numbers1.add(i);
        }

        OptionalDouble average = numbers.stream()
                .filter(value -> value % 2 == 0)
                .mapToInt(Integer::intValue)
                .average();

        System.out.println(average);

        average = numbers1.stream()
                .filter(value -> value % 2 == 0)
                .mapToInt(Integer::intValue)
                .average();

        System.out.println(average);

    }
}
