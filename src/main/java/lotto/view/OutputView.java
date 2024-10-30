package lotto.view;

import lotto.domain.LottoTickets;

public class OutputView {
    public static void LottoTicketsOutCome(LottoTickets lottoTickets){
        System.out.println(lottoTickets.size()+ "개를 구매했습니다.");
        lottoTickets.LottoTicketsOutcome();
    }
}
