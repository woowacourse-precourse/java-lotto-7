package lotto.view;

import static lotto.view.ViewMessage.INPUT_PURCHASE_PRICE;

public class OutputView {

    private OutputView() {
    }

    public static void printInputPurchasePrice() {
        printMessage(INPUT_PURCHASE_PRICE.getMessage());
    }

    private static void printMessage() {
        System.out.println();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

}