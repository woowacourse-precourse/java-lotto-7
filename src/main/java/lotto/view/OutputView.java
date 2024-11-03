package lotto.view;


import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Money;

public class OutputView {
    public void printTicketAmount(Money money) {
        System.out.println(String.format("\n%d개를 구매했습니다.", money.calculateLottoTickets()));
    }

    public void printLotto(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }
}
