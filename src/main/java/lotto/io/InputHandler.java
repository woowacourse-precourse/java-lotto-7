package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Price;

public class InputHandler {

    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String CANNOT_STRING = "입력은 문자일 수 없습니다.";
    private static final String CANNOT_EMPTY_OR_BLANK = "입력은 공백이거나 비어있을 수 없습니다.";
    private static final String WHITE_SPACE = " ";

    public Price getPriceFromUser() {
        try {
            String priceString = Console.readLine();
            validateEmptyOrBlank(priceString);
            int price = parseAsInteger(priceString);

            return new Price(price);
        } catch (IllegalArgumentException exception) {
            System.out.println(formatErrorMessage(exception.getMessage()));
            return getPriceFromUser();
        }
    }

    private int parseAsInteger(String purchaseString) {
        try {
            return Integer.parseInt(purchaseString);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(CANNOT_STRING);
        }
    }

    private void validateEmptyOrBlank(String input) {
        if (isInputBlankOrEmpty(input)) {
            throw new IllegalArgumentException(CANNOT_EMPTY_OR_BLANK);
        }
    }

    private boolean isInputBlankOrEmpty(String input) {
        return input.isBlank() || input.isEmpty();
    }

    private String formatErrorMessage(String nativeErrorMessage) {
        return String.join(WHITE_SPACE, ERROR_PREFIX, nativeErrorMessage);
    }
}