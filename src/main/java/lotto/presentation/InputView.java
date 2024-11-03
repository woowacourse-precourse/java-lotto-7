package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import lotto.global.ErrorMessage;

public class InputView {
    private static final String PROMPT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static int getMoney() {
        System.out.println(PROMPT_MONEY);
        String rawInput = getValidatedInput(InputValidator::validateMoneyInput);
        return parseToInteger(rawInput);
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(PROMPT_WINNING_NUMBERS);
        String rawInput = getValidatedInput(InputValidator::validateLottoNumbersInput);
        return parseToIntegerList(rawInput);
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println(PROMPT_BONUS_NUMBER);
        String rawInput = getValidatedInput(input -> InputValidator.validateBonusNumberInput(input, winningNumbers));
        return parseToInteger(rawInput);
    }

    private static String getValidatedInput(Consumer<String> validator) {
        String input = readLine();
        try {
            validator.accept(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedInput(validator);
        }
    }

    private static String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            System.out.println(ErrorMessage.NO_LINES_FOUND.getMessage());
            throw new NoSuchElementException(ErrorMessage.NO_LINES_FOUND.getMessage());
        }
    }

    private static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static List<Integer> parseToIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(InputView::parseToInteger)
                .toList();
    }
}
