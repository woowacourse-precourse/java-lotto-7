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
    //각각의 로또가 당첨숫자와 몇개가 일치하는지,보너스 숫자가 일치하는지 반환하는 로직
    public Map<Integer, Boolean> play() {
        lottoList.forEach(lotto -> {
            int matchCount = countMatches(lotto);
            boolean hasBonusMatch = checkBonusMatch(lotto);
            matchingNumber.put(matchCount, hasBonusMatch);
        });
        return matchingNumber;
    }
    //당첨숫자와 로또 비교 메소드
    private int countMatches(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
    //보너스 숫자와 비교 메소드
    private boolean checkBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
