package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import lotto.global.ErrorMessage;

public class InputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String PROMPT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBERS = LINE_SEPARATOR + "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = LINE_SEPARATOR + "보너스 번호를 입력해 주세요.";

    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static String getMoney() {
        System.out.println(PROMPT_MONEY);
        return getValidatedInput(InputValidator::validateMoneyInput);
    }

    public static String getWinningNumbers() {
        System.out.println(PROMPT_WINNING_NUMBERS);
        return getValidatedInput(InputValidator::validateLottoNumbersInput);
    }

    public static String getBonusNumber(List<Integer> winningNumbers) {
        System.out.println(PROMPT_BONUS_NUMBER);
        return getValidatedInput(input -> InputValidator.validateBonusNumberInput(input, winningNumbers));
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
}
