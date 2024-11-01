package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public void printLottoTicket(List<Lotto> lottoTickets, int lottoTicketNumber){
        System.out.println(lottoTicketNumber + "개를 구매했습니다.");
        for(Lotto lotto : lottoTickets){
            System.out.println(lotto);
        }
    }

    public void printResult(int matchCount, int prizeMoney, int winningCount){
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println(matchCount + "개 일치 (" + df.format(prizeMoney) + "원) -" + winningCount + "개");
    }
}
