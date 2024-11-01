package lotto.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static lotto.common.ErrorMessage.ERROR_MESSAGE;
import static lotto.common.NumberConstants.LOTTO_LENGTH;

public class Lotto implements Iterable<Integer> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (hasCorrectSize(numbers)) return;
        throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 6개여야 합니다.");
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
