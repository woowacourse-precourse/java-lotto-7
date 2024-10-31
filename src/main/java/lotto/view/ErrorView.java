package lotto.view;

public class ErrorView {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MONEY_PARSING_ERROR_MESSAGE = "구입 금액은 2,147,483,000원 이하의 숫자여야 합니다.";

    public void printMoneyParsingError() {
        System.out.println(ERROR_PREFIX + MONEY_PARSING_ERROR_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}