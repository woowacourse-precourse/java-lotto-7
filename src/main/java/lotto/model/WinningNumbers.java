package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateLength(winningNumbers);
        validateDuplicates(winningNumbers);
        validateOverFourtySix(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateDuplicates(List<Integer> parsedNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(parsedNumbers);
        if (uniqueNumbers.size() != parsedNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 수는 입력하실 수 없습니다.");
        }
    }

    private static void validateLength(List<Integer> parsedNumbers) {
        if (parsedNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateOverFourtySix(List<Integer> parsedNumbers) {
        if (parsedNumbers.stream().anyMatch(number -> number >= 46)) {
            throw new IllegalArgumentException("[ERROR] 최대 45까지만 입력 가능합니다.");
        }
    }

    public void checkBonusDuplicate(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 포함되는 수는 보너스 번호로 입력할 수 없습니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
