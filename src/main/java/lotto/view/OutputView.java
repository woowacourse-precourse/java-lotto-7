package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    public void printLottoTicket(List<Lotto> lottoTickets, int lottoTicketNumber){
        System.out.println(lottoTicketNumber + "개를 구매했습니다.");
        for(Lotto lotto : lottoTickets){
            System.out.println(lotto);
        }
    }
}
