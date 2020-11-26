package lesson7;

import kotlin.NotImplementedError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class JavaDynamicTasks {
    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     *
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */
    public static String longestCommonSubSequence(String first, String second) {
        //и трудоемкость и ресурсоемкость o(m * n) m и n длины строк
        StringBuilder result = new StringBuilder();
        int[][] subSequence = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j ++) {
                if (first.charAt(i) == second.charAt(j)) {
                    subSequence[i + 1][j + 1] = subSequence[i][j] +1;
                } else subSequence[i + 1][j + 1] = Math.max(subSequence[i + 1][j], subSequence[i][j + 1]);
            }
        }
        int i = first.length();
        int j = second.length();
        while (i > 0 && j > 0) {
            if (first.charAt(i - 1) == second.charAt(j - 1)) {
                result.insert(0, first.charAt(i - 1));
                i--;
                j--;
            } else if (subSequence[i][j] == subSequence[i - 1][j]) {
                i--;
            } else j--;
        }
        return result.toString();
    }

    /**
     * Наибольшая возрастающая подпоследовательность
     * Сложная
     *
     * Дан список целых чисел, например, [2 8 5 9 12 6].
     * Найти в нём самую длинную возрастающую подпоследовательность.
     * Элементы подпоследовательности не обязаны идти подряд,
     * но должны быть расположены в исходном списке в том же порядке.
     * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
     * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
     * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
     */
    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {
        //трудоемкость о(n^2) ресурсоемкость о(n)
        List<Integer> result = new ArrayList<>();
        if (list.size() <= 1) return list;
        int[] lisLength = new int[list.size()];
        int[] recovery = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            lisLength[i] = 1;
            recovery[i] = -1;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) < list.get(i) && lisLength[j] + 1 > lisLength[i]) {
                    lisLength[i] = lisLength[j] + 1;
                    recovery[i] = j;
                }
            }
        }
        int lastPos = 0;
        int length = lisLength[0];
        for (int i = 0; i < list.size(); i++) {
            if (lisLength[i] > length) {
                lastPos = i;
                length = lisLength[i];
            }
        }
        while (lastPos != -1) {
            result.add(list.get(lastPos));
            lastPos = recovery[lastPos];
        }
        Collections.reverse(result); // не нашел как можно добавлять элемент в начало массива, а не конец
        return result;
    }

    /**
     * Самый короткий маршрут на прямоугольном поле.
     * Средняя
     *
     * В файле с именем inputName задано прямоугольное поле:
     *
     * 0 2 3 2 4 1
     * 1 5 3 4 6 2
     * 2 6 2 5 1 3
     * 1 4 3 2 6 2
     * 4 2 3 1 5 0
     *
     * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
     * В каждой клетке записано некоторое натуральное число или нуль.
     * Необходимо попасть из верхней левой клетки в правую нижнюю.
     * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
     * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
     *
     * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
     */
    public static int shortestPathOnField(String inputName) {
        throw new NotImplementedError();
    }

    // Задачу "Максимальное независимое множество вершин в графе без циклов"
    // смотрите в уроке 5
}
