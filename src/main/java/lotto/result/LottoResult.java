package lotto.result;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.purchase.LottoPurchase;
import lotto.service.LottoChecker;

import java.util.List;

public class LottoResult {
    private final List<Lotto> purchasedLottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int[] matchCounts = new int[5];
    public LottoResult(LottoPurchase lottoPurchase, List<Integer> winningNumbers, int bonusNumber) {
        this.purchasedLottos = lottoPurchase.getPurchasedLottos();
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        calculateResults();
    }
    private void calculateResults() {
        for (Lotto lotto : purchasedLottos) {
            Prize prize = new LottoChecker().checkPrize(lotto, winningNumbers, bonusNumber);
            incrementMatchCount(prize);
        }
    }
    private void incrementMatchCount(Prize prize) {
        if(prize.getIndex() >= 0){
            matchCounts[prize.getIndex()]++;
        }
    }

    public int getTotalPrize(){
        int totalPrize = 0;
        totalPrize += matchCounts[4] * 2_000_000_000;
        totalPrize += matchCounts[3] * 30_000_000;
        totalPrize += matchCounts[2] * 1_500_000;
        totalPrize += matchCounts[1] * 50_000;
        totalPrize += matchCounts[0] * 5_000;
        return totalPrize;
    }

    public void printResults() {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + matchCounts[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts[4] + "개");
    }
}
