package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumber;

    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> winningNumber, Integer bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = sortNumbers(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다");
        }

        boolean flag = winningNumbers.stream().allMatch(this::validateRange);
        if (!flag || !validateRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 번호는 1이상 45 이하의 숫자로 이루어져야 합니다.");
        }

        HashSet<Integer> set = new HashSet<>(winningNumbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    private boolean validateRange(Integer num) {
        return 1 <= num && num <= 45;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }
    public List<Integer> getWinningNumber() {
        return Collections.unmodifiableList(winningNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
