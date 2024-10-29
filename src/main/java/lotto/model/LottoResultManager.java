package lotto.model;

import java.util.List;
import lotto.model.enums.LottoResult;

public class LottoResultManager {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoResultManager(Lotto winningNumbers, BonusNumber bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void checkLottos(List<Lotto> lottos){
        LottoResult.initializeCount();
        for(Lotto lotto : lottos){
            int countMatchingNumbers = countMatchingNumbers(lotto, winningNumbers);
            LottoResult.updatePrizeCount(countMatchingNumbers, checkSecondPrizeMatch(lotto));
        }
    }


    private int countMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        int count = 0;
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
