package lotto.view;

public class OutView {
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE + " : " + errorMessage);
    }

    public void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

}
