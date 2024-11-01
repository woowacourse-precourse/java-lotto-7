package lotto.view;

import static lotto.constant.ExceptionMessage.NOT_NUMBER_MONEY;
import static lotto.constant.ExceptionMessage.NOT_NUMBER_WINNING_NUMBER;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static long money() {
        try {
            return Long.parseLong(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MONEY.getMessage());
        }
    }

    public static List<Integer> winningNumbers() {
        try {
            return Arrays.stream(input().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_WINNING_NUMBER.getMessage());
        }
    }

    public static int bonusNumber() {
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static String input() {
        return Console.readLine();
    }
}
