package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.Winning;

public class OutputView {

    public void printIssuedLottos(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getAmount() + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printResult(Winning winning, double rateOfReturn) {
        printWinningDetails(winning);
        printRateOfReturn(rateOfReturn);
    }

    public void printWinningDetails(Winning winning) {
        System.out.println("당첨 통계" + "\n" + "---");

        for (Rank rank: winning.getAllRanks()) {
            System.out.println(rank.getMessage() + winning.getCount(rank) + "개");
        }
    }

    private void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

}
