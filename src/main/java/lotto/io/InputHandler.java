package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.Sign;
import lotto.domain.common.Price;
import lotto.domain.number.BonusNumber;
import lotto.domain.number.WinningNumbers;

public class InputHandler {

    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String CANNOT_STRING = "입력은 문자일 수 없습니다.";
    private static final String CANNOT_EMPTY_OR_BLANK = "입력은 공백이거나 비어있을 수 없습니다.";

    public Price getPriceFromUser() {
        try {
            String priceString = Console.readLine();
            validateEmptyOrBlank(priceString);
            int price = parseAsInteger(priceString);

            return new Price(price);
        } catch (IllegalArgumentException exception) {
            printExceptionReason(exception.getMessage());
            return getPriceFromUser();
        }
    }

    public WinningNumbers getWinningNumbersFromUser() {
        try {
            String winningNumbersString = Console.readLine();
            validateEmptyOrBlank(winningNumbersString);
            List<Integer> winningNumbers = retrieveWinningNumbers(winningNumbersString);

            return new WinningNumbers(winningNumbers);
        } catch (IllegalArgumentException exception) {
            printExceptionReason(exception.getMessage());
            return getWinningNumbersFromUser();
        }
    }

    public BonusNumber getBonusNumberFromUser() {
        try {
            String bonusNumberString = Console.readLine();
            validateEmptyOrBlank(bonusNumberString);
            int bonusNumber = parseAsInteger(bonusNumberString);

            return new BonusNumber(bonusNumber);
        } catch (IllegalArgumentException exception) {
            printExceptionReason(exception.getMessage());
            return getBonusNumberFromUser();
        }
    }

    private List<Integer> retrieveWinningNumbers(String numbersString) {
        return Arrays.stream(numbersString.split(Sign.COMMA))
                .map(this::parseAsInteger)
                .toList();
    }

    private void validateEmptyOrBlank(String input) {
        if (isInputBlankOrEmpty(input)) {
            throw new IllegalArgumentException(CANNOT_EMPTY_OR_BLANK);
        }
    }

    private int parseAsInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(CANNOT_STRING);
        }
    }

    private boolean isInputBlankOrEmpty(String input) {
        return input.isBlank() || input.isEmpty();
    }

    private void printExceptionReason(String nativeExceptionMessage) {
        System.out.println(formatExceptionMessage(nativeExceptionMessage));
    }

    private String formatExceptionMessage(String nativeExceptionMessage) {
        return String.join(Sign.WHITE_SPACE, ERROR_PREFIX, nativeExceptionMessage);
    }
}