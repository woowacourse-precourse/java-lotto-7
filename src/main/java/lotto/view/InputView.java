package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String pattern = String.format(".*[^0-9%s]+.*", DELIMITER);

    public static int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        validatePositiveInteger(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> getWinnerNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        validateDelimiter(input);
        List<String> numbers = Arrays.stream(input.split(DELIMITER)).toList();
        validateNumbers(numbers);
        return numbers.stream().map(Integer::parseInt).toList();
    }

    public static int getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        validatePositiveInteger(input);
        return Integer.parseInt(input);
    }

    private static String readLine() {
        return Console.readLine();
    }

    private static void validateNumbers(List<String> input) {
        for (String str : input) {
            validatePositiveInteger(str);
        }
    }

    private static void validateDelimiter(String input) {
        if (input.matches(pattern)) {
            throw new IllegalArgumentException(String.format("구분자는 %s를 사용해주세요", DELIMITER));
        }
    }

    private static void validatePositiveInteger(String input) {
        if (!input.matches("^[0-9]+$") || Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException("양의 정수가 아닙니다.");
        }
    }
}
