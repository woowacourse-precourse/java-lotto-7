package lotto.model;

import java.util.List;
import lotto.enums.LottoPrizes;

public class LottoResult {

    public void checkLottoIsWinner(WinningLotto winningLotto, UserLotto userLotto) {
        for (Lotto lotto : userLotto.getLotto()) {
            List<Integer> userNumbers = lotto.getNumbers();
            List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();
            int bonusNumber = winningLotto.getBonusNumber();
            // 사용자 번호와 당첨 번호 간의 일치 개수 확인
            long matchingCount = userNumbers.stream()
                    .filter(winningNumbers::contains)
                    .count();

            boolean isBonusMatched = userNumbers.contains(bonusNumber);
            checkRank(matchingCount, isBonusMatched);
        }
    }

    private void checkRank(long matchingCount, boolean isBonusMatched) {
        LottoPrizes.checkLottoRank(matchingCount, isBonusMatched);
    }

    public double calculateRateOfReturn(UserLotto userLotto) {
        int allPrizeMoney = 0;
        for (LottoPrizes prize : LottoPrizes.values()) {
            for (int i = 0; i < prize.getCount(); i++) {
                allPrizeMoney += prize.moneyToInt();
            }
        }
        int price = userLotto.getPrice();

        double rateOfReturn = (double) (allPrizeMoney * 100) / price;
        return Math.round(rateOfReturn * 100.0) / 100.0;
    }
}
