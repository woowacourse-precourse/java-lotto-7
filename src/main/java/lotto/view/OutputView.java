package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String PURCHASE_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.\n";
    private static final String NUMBERS_MESSAGE_FORMAT = "[%s]\n";

    private static final String NUMBERS_FORMAT_DELIMITER = ", ";

    public void displayPurchases(List<Lotto> purchases) {
        displayPurchaseCount(purchases.size());
        for (Lotto lotto : purchases) {
            displayNumbers(lotto);
        }
    }

    private void displayPurchaseCount(Integer count) {
        System.out.printf(PURCHASE_COUNT_MESSAGE_FORMAT, count);
    }

    private void displayNumbers(Lotto lotto) {
        List<String> numbers = lotto.getNumbers().stream().map(String::valueOf).toList();

        System.out.printf(NUMBERS_MESSAGE_FORMAT, String.join(NUMBERS_FORMAT_DELIMITER, numbers));
    }
}
