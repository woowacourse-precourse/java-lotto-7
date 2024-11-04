package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoChecker {
    List<Integer> rankCounts;
    List<Integer> winningNumber;
    static List<Integer> winningPrize;
    int bonusNumber;

    static {
        winningPrize = new ArrayList<>(Collections.nCopies(LottoRank.values().length, 0));

        for (LottoRank rank : LottoRank.values()) {
            winningPrize.set(rank.getRank(), LottoPrize.valueOf(rank.name()).getPrize());
        }
    }

    public LottoChecker(List<Integer> winningNumber, int bonusNumber) {
        rankCounts = new ArrayList<>(Collections.nCopies(LottoRank.values().length, 0));
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;

    }

    public void recordLottoRank(Lotto lotto) {
        int lottoRank = lotto.getLottoRank(winningNumber, bonusNumber);
        rankCounts.set(lottoRank, rankCounts.get(lottoRank) + 1);
    }

    public void printRankResult() {
        System.out.println("3개 일치 (5,000원) - " +  rankCounts.get(LottoRank.FIFTH.getRank()) +"개");
        System.out.println("4개 일치 (50,000원) - " + rankCounts.get(LottoRank.FOURTH.getRank()) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCounts.get(LottoRank.THIRD.getRank()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts.get(LottoRank.SECOND.getRank()) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCounts.get(LottoRank.FIRST.getRank()) +"개");
    }

    public Integer getTotalPrize() {
        Integer totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalPrize += rankCounts.get(rank.getRank()) * winningPrize.get(rank.getRank());
        }
        return totalPrize;
    }
}
