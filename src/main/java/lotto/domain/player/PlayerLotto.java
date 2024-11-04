package lotto.domain.player;

import java.util.List;

public class PlayerLotto {

    private List<Integer> lottoNumbers;
    private int winningCount;
    private int bonusCount;

    public PlayerLotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.winningCount = 0;
        this.bonusCount = 0;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    public void increaseWinningCount() {
        this.winningCount++;
    }

    public void increaseBonusCount() {
        this.bonusCount++;
    }
}
