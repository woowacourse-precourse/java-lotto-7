package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.common.ErrorMessage.ERROR_MESSAGE;
import static lotto.common.NumberConstants.LOTTO_LENGTH;

public final class Lotto implements Iterable<Integer> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (hasCorrectSize(numbers)) return;
        throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 6개여야 합니다.");
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> duplicateNumbers = new HashSet<>(numbers).stream()
                .toList();
        if (hasCorrectSize(duplicateNumbers)) return;
        throw new IllegalArgumentException(ERROR_MESSAGE + "에 중복된 번호가 있습니다.");
    }

    private boolean hasCorrectSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_LENGTH;
    }

    public Map<Integer, Boolean> toMap() {
        return numbers.stream()
                .collect(Collectors.toMap(number -> number, number -> true));
    }

    public Boolean isMatched(Integer key) {
        return Optional.ofNullable(toMap().get(key)).orElse(false);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}