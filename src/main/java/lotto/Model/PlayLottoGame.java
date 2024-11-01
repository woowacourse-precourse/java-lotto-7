package lotto.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class PlayLottoGame {
    private final ArrayList<Integer> winningNumbers;
    private final List<Lotto> lottoList;
    private final Map<Integer, Boolean> matchingNumber;
    private final int bonusNumber;

    public PlayLottoGame(ArrayList<Integer> winningNumbers, List<Lotto> lottoList, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.lottoList = lottoList;
        this.bonusNumber = bonusNumber;
        this.matchingNumber = new HashMap<>();
    }

    public Map<Integer, Boolean> play() {
        lottoList.forEach(lotto -> {
            int matchCount = countMatches(lotto);
            boolean hasBonusMatch = checkBonusMatch(lotto);
            matchingNumber.put(matchCount, hasBonusMatch);
        });
        return matchingNumber;
    }

    private int countMatches(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean checkBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
