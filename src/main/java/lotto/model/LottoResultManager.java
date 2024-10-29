package lotto.model;

import static lotto.utils.Constants.INITIALIZE_VALUE;
import static lotto.utils.Constants.PERCENTAGE_MULTIPLIER;

import java.util.List;
import lotto.model.enums.LottoResult;

public class LottoResultManager {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;
    private final Integer price;

    public LottoResultManager(Lotto winningNumbers, BonusNumber bonusNumber, Integer price){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.price = price;
    }

    public void checkLottos(List<Lotto> lottos){
        LottoResult.initializeCount();
        for(Lotto lotto : lottos){
            int countMatchingNumbers = countMatchingNumbers(lotto, winningNumbers);
            LottoResult.updatePrizeCount(countMatchingNumbers, checkSecondPrizeMatch(lotto));
        }
    }

    public double calculateProfit() {
        return ((double) LottoResult.getTotalPrize() / price) * PERCENTAGE_MULTIPLIER;
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

    private boolean checkSecondPrizeMatch(Lotto lotto){
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }

}
