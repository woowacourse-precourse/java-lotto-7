package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {

    public void printGeneratedLottoTickets(int lottoAmount, List<Lotto> lottoTickets) {
        System.out.println(lottoAmount + "개를 구매했습니다.");

        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }

    public void printTotalLottoResult(Map<Prize, Integer> totalPrizeCount) {
        for (Prize prize : totalPrizeCount.keySet()) {
            System.out.println(prize.toString());
        }
    }

    public void printTotalProfit(BigDecimal totalProfit) {
        System.out.println("총 수익률은 " + totalProfit + "%입니다.");
    }
}
