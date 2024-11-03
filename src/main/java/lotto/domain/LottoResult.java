package lotto.domain;

import java.util.List;

public class LottoResult {
    private static final int THREE_MATCHES_PRIZE = 5000;
    private static final int FOUR_MATCHES_PRIZE = 50000;
    private static final int FIVE_MATCHES_PRIZE = 1500000;
    private static final int FIVE_MATCHES_WITH_BONUS_PRIZE = 30000000;
    private static final int SIX_MATCHES_PRIZE = 2000000000;

    private int threeMatchesCount;
    private int fourMatchesCount;
    private int fiveMatchesCount;
    private int fiveMatchesWithBonusCount;
    private int sixMatchesCount;

    public LottoResult() {
        this.threeMatchesCount = 0;
        this.fourMatchesCount = 0;
        this.fiveMatchesCount = 0;
        this.fiveMatchesWithBonusCount = 0;
        this.sixMatchesCount = 0;
    }

    public void countMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        int count = 0;
        boolean isMachtedBonusNumber = BonusNumber.isMatchedBonusNumber(lotto);
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (winningLottoNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        updateLottoResult(count, isMachtedBonusNumber);
    }

    public StringBuilder getResultMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("3개 일치 (5,000원) - " + threeMatchesCount + "개\n");
        stringBuilder.append("4개 일치 (50,000원) - " + fourMatchesCount + "개\n");
        stringBuilder.append("5개 일치 (1,500,000원) - " + fiveMatchesCount + "개\n");
        stringBuilder.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveMatchesWithBonusCount + "개\n");
        stringBuilder.append("6개 일치 (2,000,000,000원) - " + sixMatchesCount + "개\n");
        return stringBuilder;
    }

    public int getTotalPrizeAmount() {
        int totalPrizeAmount = 0;
        totalPrizeAmount += threeMatchesCount * THREE_MATCHES_PRIZE;
        totalPrizeAmount += fourMatchesCount * FOUR_MATCHES_PRIZE;
        totalPrizeAmount += fiveMatchesCount * FIVE_MATCHES_PRIZE;
        totalPrizeAmount += fiveMatchesWithBonusCount * FIVE_MATCHES_WITH_BONUS_PRIZE;
        totalPrizeAmount += sixMatchesCount * SIX_MATCHES_PRIZE;

        return totalPrizeAmount;
    }

    private void updateLottoResult(int count, boolean isMachtedBonusNumber) {
        if (count == 3) {
            threeMatchesCount++;
            return;
        }
        if (count == 4) {
            fourMatchesCount++;
            return;
        }
        if (count == 5 && isMachtedBonusNumber) {
            fiveMatchesWithBonusCount++;
            return;
        }
        if (count == 5) {
            fiveMatchesCount++;
            return;
        }
        if (count == 6) {
            sixMatchesCount++;
        }
    }

}
