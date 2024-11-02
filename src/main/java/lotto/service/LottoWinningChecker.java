package lotto.service;

import java.util.HashSet;
import java.util.List;
import lotto.utils.Utils;

public class LottoWinningChecker {
    private HashSet<Integer> winningNumbs;
    private int bonusNumber;

    LottoWinningChecker() {
    }

    public void saveWinningNumbs(List<Integer> validatedWinningNumbs) {
        winningNumbs = new HashSet<>(validatedWinningNumbs);
    }

    public void saveBonusNumber(int bonusNumber) {
        if (winningNumbs.contains(bonusNumber)) {
            throw new IllegalArgumentException(Utils.makeErrorMessage("보너스 번호가 당첨번호와 중복됩니다."));
        }
        this.bonusNumber = bonusNumber;
    }

    public HashSet<Integer> getWinningNumbs() {
        return winningNumbs;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
