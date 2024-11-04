package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class LottoOutputView {
    private static final int FOR_PRINT_FROM_SECOND = 2;

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(int[] rankCounts, float rateOfRevenue) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = rankCounts.length - FOR_PRINT_FROM_SECOND; i >= 0; i--) {
            LottoRank lottoRank = LottoRank.values()[i];
            if (lottoRank.hasBonusNumber()) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", lottoRank.getWinningCount(), lottoRank.getPrize(),
                        rankCounts[i]);
                continue;
            }
            System.out.printf("%d개 일치 (%,d원) - %d개\n", lottoRank.getWinningCount(), lottoRank.getPrize(),
                    rankCounts[i]);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfRevenue);
    }
}
