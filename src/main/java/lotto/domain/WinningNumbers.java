package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final Set<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 반드시 6개의 숫자를 포함해야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.winningNumbers = Set.copyOf(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public Set<Integer> getWinningNumbers() {
        return Set.copyOf(winningNumbers);
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
