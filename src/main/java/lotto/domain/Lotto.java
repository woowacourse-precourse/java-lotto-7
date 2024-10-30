package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public Rank getResult(Set<Integer> winningNumbers, int bonusNumber) {
        boolean isBonusMatched = false;

        List<Integer> missedNumbers = numbers.stream()
                .filter(number -> !winningNumbers.contains(number))
                .toList();
        int matchedNumberCount = LOTTO_SIZE - missedNumbers.size();
        if (matchedNumberCount == 5 && missedNumbers.getFirst() == bonusNumber) {
            isBonusMatched = true;
        }
        return Rank.getRank(matchedNumberCount, isBonusMatched);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }
}
