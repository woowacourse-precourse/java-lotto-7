package lotto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoWinning {
    private int bonusNumber;
    private Lotto winningNumbers;
    private LottoDraw lottoDraw;
    private Map<String, Integer> winningLotto;

    public LottoWinning(Lotto winningNumbers, int bonusNumber, LottoDraw lottoDraw) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
        this.lottoDraw = lottoDraw;
        this.winningLotto = setWinningLotto();
        calculateWinningResult();
    }

    public Map<String, Integer> getWinningLotto() {
        return winningLotto;
    }

    private Map<String, Integer> setWinningLotto() {
        Map<String, Integer> setWinningLotto = new LinkedHashMap<>();
        setWinningLotto.put("3개 일치", 0);
        setWinningLotto.put("4개 일치", 0);
        setWinningLotto.put("5개 일치", 0);
        setWinningLotto.put("5개 일치, 보너스 볼 일치", 0);
        setWinningLotto.put("6개 일치", 0);
        return setWinningLotto;
    }

    private void calculateWinningResult() {
        for (Lotto lotto : lottoDraw.getLottoDrawNumbers()) {
            int matchCount = calculateMatchCount(lotto);
            boolean hasBonus = hasBonusNumber(lotto);
            String mapKeyString = updateWinningLotto(matchCount, hasBonus);
            winningLotto.computeIfPresent(mapKeyString, (k, v) -> v + 1);
        }
    }

    private int calculateMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int numbers : lotto.getNumbers()) {
            if (winningNumbers.getNumbers().contains(numbers)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private String updateWinningLotto(int matchCount, boolean hasBonus) {
        String returnString = matchCount + "개 일치";
        if (matchCount == 5 && hasBonus) {
            returnString += ", 보너스 볼 일치";
        }

        return returnString;
    }
}
