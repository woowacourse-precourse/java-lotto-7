package lotto.model;

import java.util.List;
import lotto.message.ErrorMessage;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers.size());
        validateNumbers(numbers);
        validateNumbersDuplicate(numbers);
    }

    private void validateSize(int size) {
        if (size != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO.getMessage());
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO.getMessage());
            }
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        int number = numbers.getFirst();
        for (int i = 1; i < numbers.size(); i++) {
            if (number == numbers.get(i)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO.getMessage());
            }
            number = numbers.get(i);
        }
    }

    // TODO: 추가 기능 구현
    public void printLotto() {
        System.out.println(numbers.stream().sorted().toList());
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int getMatchCount(Lotto winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isBonusMatch(int bonusNumber) {
        return numbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }
}
