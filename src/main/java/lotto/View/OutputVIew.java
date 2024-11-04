package lotto.View;

import lotto.Domain.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputVIew {
    public void printLottoQuantityMessage(long lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        ;
    }

    public void printLottNumbers(List<Integer> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
    }

    public void printStatisticsMessage() {
        System.out.println("당첨 통계\n---");
    }

    public void printWinningLottoQuantity(Map<LottoRank, Integer> rankCount) {
        System.out.println(
                "3개 일치 (5,000원) - " + rankCount.get(LottoRank.FIFTH) + "개\n"
                        + "4개 일치 (50,000원) - " + rankCount.get(LottoRank.FOURTH) + "개\n"
                        + "5개 일치 (1,500,000원) - " + rankCount.get(LottoRank.THIRD) + "개\n"
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount.get(LottoRank.SECOND) + "개\n"
                        + "6개 일치 (2,000,000,000원) - " + rankCount.get(LottoRank.FIRST) + "개"
        );
    }

    public void printRatioOfReturn(double rate) {
        System.out.print("총 수익률은 " + rate + "%입니다.");
    }
}
