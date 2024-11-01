package lotto.store;

import lotto.basic.NumbersGenerator;

import java.util.List;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if(isInvalidSize(numbers))
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        if(hasDuplicatedNumbers(numbers))
            throw new IllegalArgumentException("로또 번호는 6개는 유니크해야 합니다.");
        if(hasNumbersOutOfRange(numbers))
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");

        this.numbers = numbers;
    }

    private boolean hasNumbersOutOfRange(List<Integer> numbers) {
        return countNumbersInRange(numbers) != numbers.size();
    }

    private long countNumbersInRange(List<Integer> numbers) {
        return numbers.stream().filter(this::isWithinLottoRange).count();
    }

    private boolean isWithinLottoRange(Integer num) {
        return MIN_LOTTO_NUMBER <= num && num <= MAX_LOTTO_NUMBER;
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private boolean hasDuplicatedNumbers(List<Integer> numbers) {
        return countUniqueNumber(numbers) != numbers.size();
    }

    private long countUniqueNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }
}
