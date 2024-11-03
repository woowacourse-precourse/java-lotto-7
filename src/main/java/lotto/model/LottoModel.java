package lotto.model;

import java.util.ArrayList;
import java.util.List;

// UserLotto와 Lotto를 이용하여 유저의 로또 정보를 비교하고 일치 개수를 통계하는 메서드들 모음
public class LottoModel {
    private int bonusNumber;
    private Lotto winningNumbers;
    private UserLotto userLotto;
    private List<Integer> winnerCount;
    private List<Boolean> matchBonus;

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setUserLotto(int numberOfLotto) {
        userLotto = new UserLotto(numberOfLotto);
    }

    public void setWinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public UserLotto getUserLotto() {
        return userLotto;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> getWinnerCount() {
        return winnerCount;
    }

    // 당첨번호와 유저의 로또 정보 비교 -> 각 로또 당 일치 개수 카운트
    public void compareLotto() {
        winnerCount = new ArrayList<>();
        for (Lotto lotto  : userLotto.getUserLotto()) {
            List<Integer> winner = new ArrayList<>();
            winner.addAll(lotto.getNumbers());
            winner.retainAll(winningNumbers.getNumbers());
            winnerCount.add(winner.size());
        }
    }

    public List<Boolean> matchBonus() {
        matchBonus = new ArrayList<>();
        for (int i = 0; i< userLotto.getNumberOfLotto(); i++ ) {
            matchBonus.add(userLotto.getLottoAt(i).contains(bonusNumber));
        }
        return matchBonus;
    }
}
