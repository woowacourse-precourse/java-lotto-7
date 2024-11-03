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
            if (rank == Rank.NONE) {
                continue;
            }

            String resultMessage = formatResultMessage(rank, lottoResult.getWinningResults().get(rank));
            System.out.println(resultMessage);
        }
    }

    @Override
    public void printReturnOnInvestment(double returnOnInvestment) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnOnInvestment);
    }

    private String formatResultMessage(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            return String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개",
                    NumberFormat.getInstance().format(rank.getPrizeMoney()), count);
        }
        return String.format("%d개 일치 (%s원) - %d개",
                rank.getMatchCount(), NumberFormat.getInstance().format(rank.getPrizeMoney()), count);
    }
}
