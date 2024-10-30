package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

public class OutputView {
    private static final String BUY_COUNT = "개를 구매했습니다.";

    public static void getLottoList(LottoMachine lottoMachine) {
        int buy = lottoMachine.getLottoTicketSize();

        System.out.println("\n" + buy + BUY_COUNT);
        for (Lotto lotto : lottoMachine.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
