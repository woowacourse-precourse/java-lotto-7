package lotto.model;

import static lotto.utils.Constants.*;
import static lotto.utils.Constants.INITIALIZE_VALUE;
import static lotto.utils.Constants.PERCENTAGE_MULTIPLIER;

import java.util.List;
import lotto.model.enums.LottoResult;
import lotto.utils.Constants;
import lotto.utils.LottoConstants;

public class LottoResultManager {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;
    private final Integer price;

    public LottoResultManager(Lotto winningNumbers, BonusNumber bonusNumber, Integer price) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.price = price;
    }

    public void checkLottos(List<Lotto> lottos) {
        LottoResult.initializeCount();

        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto, winningNumbers);

            boolean isSecondPrize = (matchCount == LottoConstants.SECOND_PRIZE_MATCH_COUNT)
                    && checkSecondPrizeMatch(lotto);

            LottoResult.updatePrizeCount(matchCount, isSecondPrize);
        }
    }


    public double calculateProfit() {
        double profit = ((double) LottoResult.getTotalPrize() / price) * PERCENTAGE_MULTIPLIER;
        return (double) Math.round(profit * ROUND_VALUE) / ROUND_VALUE;
    }


    private int countMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        int count = INITIALIZE_VALUE;
        List<Integer> winningNumbers = winningLotto.getNumbers();
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkSecondPrizeMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }

}
