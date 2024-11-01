package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;

public class OutputView {

    public void printIssuedLottos(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getAmount() + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

}
