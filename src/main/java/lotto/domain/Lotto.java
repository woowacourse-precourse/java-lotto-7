package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Converter;
import lotto.validation.WinningNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        WinningNumberValidator.validateWinningNumber(Converter.convertListToString(numbers));
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        return sortedNumbers.toString();
    }

    public int getMatchCount(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::isContain)
                .count();
    }

    public boolean isMatchBonus(BonusNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(bonusNumber::isEqual);
    }
}
