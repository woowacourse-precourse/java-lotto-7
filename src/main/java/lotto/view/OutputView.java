package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.service.LottoResult;
import lotto.enums.LottoRank;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<LottoRank, Integer> result = lottoResult.getResult();

        for (LottoRank rank : LottoRank.values()) {
            printRankResult(rank, result.getOrDefault(rank, 0));
        }

        String profitRate = String.format("%.1f", lottoResult.getProfitRate());
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    private void printRankResult(LottoRank rank, int count) {
        if (rank == LottoRank.NONE) {
            return;
        }
        String matchInfo = getMatchInfo(rank);
        String prize = formatCurrency(rank.getPrize());
        System.out.println(matchInfo + " (" + prize + ") - " + count + "개");
    }

    private String getMatchInfo(LottoRank rank) {
        if (rank == LottoRank.SECOND) {
            return rank.getMatchCount() + "개 일치, 보너스 볼 일치";
        }
        return rank.getMatchCount() + "개 일치";
    }

    private String formatCurrency(int prize) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(prize) + "원";
    }
}
