package lotto.view;

public class OutputView {

    public static void printPaymentMessage() {
        System.out.println(OutputMessages.PAYMENT.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

}