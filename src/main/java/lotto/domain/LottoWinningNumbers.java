package lotto.domain;

import java.util.Set;
import java.util.TreeSet;

public class LottoWinningNumbers {

    private Set<Integer> winningNumbers = new TreeSet<>();
    private int bonusWinningNumber;

    private LottoWinningNumbers(Set<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static LottoWinningNumbers createLottoWinningNumbers(Set<Integer> winningNumbers) {
        return new LottoWinningNumbers(winningNumbers);
    }

    public void addBonusWinningNumber(int bonusWinningNumber) {
        validateDuplicateBonusNumber(bonusWinningNumber);
        this.bonusWinningNumber = bonusWinningNumber;
    }

    private void validateDuplicateBonusNumber(int bonusWinningNumber) {
        if (winningNumbers.contains(bonusWinningNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존의 당첨 번호들과 중복일 수 없습니다.");
        }
    }

    public Set<Integer> getWinningNumbers() {
        return new TreeSet<>(winningNumbers);
    }

    public int getBonusWinningNumber() {
        return bonusWinningNumber;
    }
}
