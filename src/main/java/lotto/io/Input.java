package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public abstract class Input {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NOT_POSITIVE_NUMBER_ERROR = "[ERROR] 양수를 입력해 주세요";
    private static final String WINNING_NUMBER_FORMAT_ERROR = "[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.";

    public static int price() {
        System.out.println(INPUT_PRICE_MESSAGE);
        String input = Console.readLine();
        validatePrice(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> winningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateWinningNumber(input);
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int bonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateBonusNumber(input);
        return Integer.parseInt(input);
    }

    private static void validatePrice(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR);
        }
    }

    private static void validateWinningNumber(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR);
        }
    }

    private static void validateBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR);
        }
    }
}
