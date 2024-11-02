package lotto;

import static lotto.global.constant.Config.LOTTO_NUMBER_SIZE;
import static lotto.global.constant.ErrorMessage.LOTTO_NUMBER_OUT_OF_SIZE;
import static lotto.global.util.Validator.validateLotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto implements UniqueNumber {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        validateLotto(this);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_SIZE);
        }
    }

    @Override
    public boolean hasDuplicateNumber() {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int calculateNumberOfMatch(List<Integer> numberOfCompare) {
        return (int) numberOfCompare.stream()
                .filter(numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }

}
