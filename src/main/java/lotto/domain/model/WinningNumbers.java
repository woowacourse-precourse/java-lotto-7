package lotto.domain.model;

import java.util.List;
import java.util.stream.Collectors;

// 당첨 번호와 보너스 번호를 관리하는 클래스
public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        // ValidationService에서 이미 검증이 끝난 numbers와 bonusNumber를 그대로 할당
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream().filter(numbers::contains).count();
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
