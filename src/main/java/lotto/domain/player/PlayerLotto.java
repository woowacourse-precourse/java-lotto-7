package lotto.domain.player;

import java.util.ArrayList;
import java.util.List;

public class PlayerLotto {

    private List<Integer> lottoNumbers;
    private int WinningCount;
    private int BonusCount;

    public PlayerLotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getWinningCount() {
        return 0;
    }

    public int getBonusCount() {
        return 0;
    }

    public void updateWinningCount(int winningCount) {

    }

    public void updateBonusCount(int bonusCount) {

    }
}
