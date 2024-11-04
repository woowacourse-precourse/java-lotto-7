package lotto.domain;

import java.util.Set;
import java.util.TreeSet;

public class LottoWinningNumbers {

    private Set<Integer> winningNumbers = new TreeSet<>();
    private final int bonusWinningNumber;

    private LottoWinningNumbers(Set<Integer> winningNumbers, int bonusWinningNumber) {
        this.winningNumbers = winningNumbers;
        validateDuplicateBonusNumber(bonusWinningNumber);
        this.bonusWinningNumber = bonusWinningNumber;
    }

    public static LottoWinningNumbers createLottoWinningNumbers(Set<Integer> winningNumbers, int bonusWinningNumber) {
        return new LottoWinningNumbers(winningNumbers, bonusWinningNumber);
    }

    public Set<Integer> getWinningNumbers() {
        return new TreeSet<>(winningNumbers);
    }

    public int getBonusWinningNumber() {
        return bonusWinningNumber;
    }

    private void validateDuplicateBonusNumber(int bonusWinningNumber) {
        if (winningNumbers.contains(bonusWinningNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존의 당첨 번호들과 중복일 수 없습니다.");
        }
    }
}
