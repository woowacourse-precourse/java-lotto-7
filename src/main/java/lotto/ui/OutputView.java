package lotto.ui;

import lotto.ui.constants.ResultText;

import java.util.List;

public class OutputView {
    public void printPurchasedMessage(int amount) {
        System.out.println("\n" + amount + ResultText.PURCHASED.getText());
    }

    public void printString(String message) {
        System.out.println(message);
    }

    public void printIntegerList(List<Integer> list) {
        System.out.println(list);
    }
}
