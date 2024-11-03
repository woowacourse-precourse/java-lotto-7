package lotto.ui;

import static lotto.constant.ViewConstant.BUY_LOTTO_MESSAGE_FORMAT;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public void printPurchaseHistory(List<Lotto> purchaseHistory) {
        System.out.printf(BUY_LOTTO_MESSAGE_FORMAT + "%n", purchaseHistory.size());
        purchaseHistory.forEach(System.out::println);
    }
}
