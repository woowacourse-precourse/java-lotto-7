package view;

import java.util.List;
import lotto.Lotto;
import lotto.LottoScoreboard;

public class OutputView {
    public void outputLottoNumbers(List<Lotto> lottoList) {
        System.out.println();
        System.out.println(lottoList.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public void printScoreboard(LottoScoreboard lottoScoreboard) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoScoreboard.getThreeMatches() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoScoreboard.getFourMatches() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoScoreboard.getFiveMatches() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoScoreboard.getFiveBonusMatches() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoScoreboard.getSixMatches() + "개");
        System.out.println("총 수익률은 " + lottoScoreboard.calculateTotalProfit() + "입니다.");
    }
}
