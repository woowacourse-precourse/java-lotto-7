package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.text.NumberFormat;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.getLottos().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTicket.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public void printWinningStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%d개 일치 (%s원) - %d개%n",
                        rank.getMatchCount(),
                        NumberFormat.getInstance().format(rank.getPrizeMoney()),
                        lottoResult.getWinningResults().get(rank)
                );
            }
        }
    }

    @Override
    public void printReturnOnInvestment(double returnOnInvestment) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnOnInvestment);
    }
}
