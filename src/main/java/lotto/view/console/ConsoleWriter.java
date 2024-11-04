package lotto.view.console;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.OutputView;

public class ConsoleWriter implements OutputView {
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    @Override
    public void printPurchasedLottoCount(int count) {
        System.out.println();
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE + "%n", count);
    }

    @Override
    public void printLottoTickets(Lottos lottos) {
        for (Lotto lotto : lottos.getTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
