package lotto.common.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public final class ConsoleInput {

    public static final char DEFAULT_DELIMITER = ',';
    public static final int MIN_INTEGER_VALUE = Integer.MIN_VALUE;
    public static final int MAX_INTEGER_VALUE = Integer.MAX_VALUE;

    private ConsoleInput() {

    }

    public static void closeConsole() {
        Console.close();
    }

    public static String readString() {
        return Console.readLine();
    }

    public static List<String> readStrings() {
        return readStrings(DEFAULT_DELIMITER);
    }

    public static List<String> readStrings(char delimiter) {
        List<String> list = getTokenizedStrings(readString(), delimiter);
        return List.copyOf(list);
    }

    private static List<String> getTokenizedStrings(String input, Character delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(input, String.valueOf(delimiter));

        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken().strip());
        }
        return list;
    }

    public static Integer readInteger() {
        return readInteger(MIN_INTEGER_VALUE, MAX_INTEGER_VALUE);
    }

    public static Integer readInteger(int min, int max) {
        return parseIntegerFrom(readString(), min, max);
    }

    public static List<Integer> readIntegers() {
        return readIntegers(DEFAULT_DELIMITER, MIN_INTEGER_VALUE, MAX_INTEGER_VALUE);
    }

    public static List<Integer> readIntegers(int min, int max) {
        return readIntegers(DEFAULT_DELIMITER, min, max);
    }

    public static List<Integer> readIntegers(char delimiter, int min, int max) {
        return readStrings(delimiter).stream()
                .map((String string) -> parseIntegerFrom(string, min, max))
                .toList();
    }

    private static Integer parseIntegerFrom(String string, int min, int max) {
        try {
            Integer parsed = Integer.valueOf(string);

            if (parsed < min || max < parsed) {
                throw new IllegalArgumentException(String.format("이곳에 입력할 수 있는 정수의 범위는 %d~%d입니다.", min, max));
            }

            return parsed;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해 주세요.");
        }
    }

}
