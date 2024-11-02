package lotto.view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public void printLottoTicket(List<Lotto> lottoTickets, int lottoTicketNumber){
        System.out.println(lottoTicketNumber + "개를 구매했습니다.");
        for(Lotto lotto : lottoTickets){
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.println();
    }

    public void printResult(int matchCount, int prizeMoney, boolean isBonusMatch ,int winningCount){
        DecimalFormat df = new DecimalFormat("###,###");
        if(isBonusMatch){
            System.out.println(matchCount + "개 일치, 보너스 볼 일치 (" + df.format(prizeMoney) + "원) - " + winningCount + "개");
            return;
        }
        System.out.println(matchCount + "개 일치 (" + df.format(prizeMoney) + "원) - " + winningCount + "개");
    }

    public void printProfit(String profit){
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
