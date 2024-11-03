package lotto.domain;

import java.util.List;
import lotto.domain.constant.LottoRank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumberCount(numbers);
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
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
