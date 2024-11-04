package lotto.service;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeCalculator {
    private final Map<Prize, Integer> prizeCountMap = new HashMap<>();

    public void checkWinningNumbers(WinningNumbers winningNumbers, List<Lotto> purchasedLottos) {
        Lotto winningLotto = winningNumbers.getLotto();
        int bonusNumber = winningNumbers.getBonusNumber();

        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCount = countMatches(winningLotto.getNumbers(), purchasedLotto.getNumbers());
            boolean bonusMatch = checkBonusMatch(bonusNumber, purchasedLotto);
            Prize prize = Prize.getPrize(matchCount, bonusMatch);
            updatePrizeCount(prize);
        }
    }

    private int countMatches(List<Integer> winningNumbers, List<Integer> userNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkBonusMatch(int bonusNumber, Lotto purchasedLotto) {
        return purchasedLotto.getNumbers().contains(bonusNumber);
    }

    private void updatePrizeCount(Prize prize) {
        if (prize != null) {
            prizeCountMap.put(prize, prizeCountMap.getOrDefault(prize, 0) + 1);
        }
    }

    public Map<Prize, Integer> getPrizeCountMap() {
        return prizeCountMap;
    }
}

