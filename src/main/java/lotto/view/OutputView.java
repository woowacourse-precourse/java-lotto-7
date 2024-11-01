package lotto.view;

import java.util.List;

public class OutputView {
    private static final String DISPLAY_LOTTO_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";

    public void displayPurchasedLottoCount(int count) {
        System.out.println(String.format(DISPLAY_LOTTO_COUNT_MESSAGE_FORMAT, count));
    }
}
