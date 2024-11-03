package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateLottoNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateLottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateCount(winningNumbers);
        validateNoDuplicate(winningNumbers);
        validateAllNumbersInRange(winningNumbers);
        validateBonusNumberInRange(bonusNumber);
        validateBonusNumberNotInWinningNumbers(winningNumbers,bonusNumber);
    }

    private void validateCount(List<Integer> winningNumbers) {
        if (!isCorrectCount(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private boolean isCorrectCount(List<Integer> winningNumbers) {
        return winningNumbers.size() == 6;
    }

    private void validateNoDuplicate(List<Integer> winningNumbers) {
        if (hasDuplicates(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되면 안됩니다.");
        }
    }

    private boolean hasDuplicates(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        return uniqueNumbers.size() != winningNumbers.size();
    }

    private void validateAllNumbersInRange(List<Integer> winningNumbers) {
        if (hasOutOfRangeNumber(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean hasOutOfRangeNumber(List<Integer> winningNumbers) {
        return winningNumbers.stream().anyMatch(number -> number < 1 || number > 45);
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위 안의 숫자여야 합니다.");
        }
    }

    private boolean isOutOfRange(int bonusNumber) {
        return bonusNumber < 1 || bonusNumber > 45;
    }

    private void validateBonusNumberNotInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (isDuplicateWithWinningNumbers(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    private boolean isDuplicateWithWinningNumbers(List<Integer> winningNumbers,int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

    public int countMatchingNumbers(Lotto lotto) {
        Set<Integer> matchedNumbers = new HashSet<>(winningNumbers);
        matchedNumbers.retainAll(lotto.getNumbers());
        return matchedNumbers.size();
    }

    public boolean isBonusMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
