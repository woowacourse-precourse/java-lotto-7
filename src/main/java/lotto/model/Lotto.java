package lotto.model;

import lotto.exception.GameException;

import java.util.List;

import static lotto.model.LottoOption.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getSortedNumbersByAscending() {
        return numbers.stream()
            .sorted()
            .toList();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
        checkInRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != TOTAL_ELEMENT_COUNT.value()) {
            throw new GameException("로또 번호는 %s개여야 합니다.".formatted(TOTAL_ELEMENT_COUNT.value()));
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new GameException("중복된 번호가 있습니다.");
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private void checkInRange(List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new GameException("로또 번호는 %s부터 %s사이여야 합니다.".formatted(MIN_NUMBER_OF_RANGE.value(), MAX_NUMBER_OF_RANGE.value()));
        }
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
            .anyMatch(number -> number < MIN_NUMBER_OF_RANGE.value() || number > MAX_NUMBER_OF_RANGE.value());
    }

}
