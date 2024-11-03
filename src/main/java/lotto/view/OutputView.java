package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    private static final String PURCHASED_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.\n";

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printNumberOfPurchasedLottos(int count) {
        System.out.printf(PURCHASED_LOTTO_COUNT_FORMAT, count);
    }

    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }
}
