package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinLotto {

    private static final int MIN_NUMBER = LottoRule.MIN_NUMBER.getValue();
    private static final int MAX_NUMBER = LottoRule.MAX_NUMBER.getValue();
    private static final int NUMBER_COUNT = LottoRule.NUMBER_COUNT.getValue();

    private final List<Integer> numbers;
    private Integer bonusNumber;

    public WinLotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public void setBonusNumber(Integer number) {
        validateBonusNumber();
        bonusNumber = number;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber() {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 달라야 합니다.");
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 중복되면 안됩니다.");
        }
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("당첨 번호는 %d개여야 합니다.", NUMBER_COUNT));
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(String.format("당첨 번호는 %d ~ %d 범위여야 합니다.", MIN_NUMBER, MAX_NUMBER));
        }
    }
}
