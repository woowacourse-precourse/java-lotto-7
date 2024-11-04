package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotteryDrawMachine {
    private final Set<Integer> jackpotNumbers;
    private final int bonusNumber;

    public LotteryDrawMachine(List<Integer> jackpotNumbers, int bonusNumber) {
        if (jackpotNumbers.size() != 6 || !jackpotNumbers.stream().allMatch(n -> n >= 1 && n <= 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45 || jackpotNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며 당첨 번호와 중복될 수 없습니다.");
        }
        this.jackpotNumbers = new HashSet<>(jackpotNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getJackpotNumbers() {
        return jackpotNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
