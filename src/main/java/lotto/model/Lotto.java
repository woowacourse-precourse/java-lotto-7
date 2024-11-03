package lotto.model;

import static lotto.config.ConsoleMessage.CLOSE_WRAPPER;
import static lotto.config.ConsoleMessage.JOINT;
import static lotto.config.ConsoleMessage.OPEN_WRAPPER;
import static lotto.config.SystemConfig.DOMAIN_END;
import static lotto.config.SystemConfig.DOMAIN_START;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.config.ErrorMessage;
import lotto.config.SystemConfig;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Comparator.naturalOrder());
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        findDuplication(numbers);
        findNegativeDigit(numbers);
        validateDomain(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(ErrorMessage.NUMBER_INSUFFICIENT);
        }
    }

    private void findDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != SystemConfig.NUMBERS) {
            throw new LottoException(ErrorMessage.DUPLICATE);
        }
    }

    private void findNegativeDigit(List<Integer> numbers) {
        if (numbers.stream().anyMatch(value -> value <= 0)) {
            throw new LottoException(ErrorMessage.NEGATIVE_DIGIT);
        }
    }

    private boolean isOutOfDomain(int value) {
        return value < DOMAIN_START || value > DOMAIN_END;
    }

    private void validateDomain(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isOutOfDomain)) {
            throw new LottoException(ErrorMessage.DOMAIN);
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int subtract(Lotto other) {
        int count = 0;
        for (int number : other.numbers) {
            if (!contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    @Override
    public boolean equals(Object obj) {
        Lotto other = (Lotto) obj;
        Set<Integer> oursNum = new HashSet<>(numbers);
        Set<Integer> othersNum = new HashSet<>(other.numbers);
        return oursNum.equals(othersNum);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(JOINT, OPEN_WRAPPER, CLOSE_WRAPPER));
    }
}
