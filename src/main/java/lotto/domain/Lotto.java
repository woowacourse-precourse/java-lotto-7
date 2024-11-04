package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.Constant;
import lotto.error.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBERS.getMessage());
        }
        if (!validateDuplication(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
        if (!validateInRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_NOT_IN_RANGE.getMessage());
        }
    }

    private boolean validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == Constant.LOTTO_SIZE;

    }

    private boolean validateInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> Constant.MIN_NUMBER <= number && number <= Constant.MAX_NUMBER);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumbers() {
        System.out.print("[");
        for (int i=0; i < Constant.LOTTO_SIZE; i++) {
            if(i == numbers.size() - 1) {
                System.out.print(numbers.get(i));
                continue;
            }
            System.out.print(numbers.get(i) + Constant.COMMA_SEPARATOR + " ");
        }
        System.out.println("]");
    }
}
