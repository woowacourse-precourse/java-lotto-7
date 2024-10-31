package lotto.view;

public class ErrorView {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MONEY_PARSING_ERROR_MESSAGE = "금액은 숫자로 입력해야 합니다.";

    public void printMoneyInputError() {
        System.out.println(ERROR_PREFIX + MONEY_PARSING_ERROR_MESSAGE);
    }
}
