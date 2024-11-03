package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.constant.LottoRank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void checkRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(s -> {
                    if (s > 45 || s < 1) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45를 벗어날 수 없습니다.");
                    }
                });
    }

    private int matchWinningNumbers(List<Integer> numbers) {
        return (int) this.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean matchBonusNumber(Integer number) {
        return numbers.contains(number);
    }

    public LottoRank getRank(Winning winning) {
        int matchingNumbers = matchWinningNumbers(winning.getNumbers());
        boolean isBonusMatch = matchBonusNumber(winning.getBonusNumber());

        return LottoRank.valueOf(matchingNumbers, isBonusMatch);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        return numbers.toString();
    }

}
