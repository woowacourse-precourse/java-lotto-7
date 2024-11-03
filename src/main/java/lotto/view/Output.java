package lotto.view;

import lotto.domain.LottoTicket;

public class Output {

    public void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println("\n" + lottoTicket.getSize() + "개를 구매했습니다.");
        System.out.println(lottoTicket);
    }
}
