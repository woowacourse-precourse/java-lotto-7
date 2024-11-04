package lotto.application.ticket.domain.ticket;

import static lotto.application.ticket.domain.ticket.LottoNumberRule.END_INCLUSIVE;
import static lotto.application.ticket.domain.ticket.LottoNumberRule.SIZE;
import static lotto.application.ticket.domain.ticket.LottoNumberRule.START_INCLUSIVE;
import static lotto.application.ticket.message.Message.DUPLICATE_NUMBER_MESSAGE;
import static lotto.application.ticket.message.Message.INVALID_RANGE_MESSAGE;
import static lotto.application.ticket.message.Message.INVALID_SIZE_MESSAGE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        validate(numbers);
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    private static boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }

    private static boolean isValidRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> (number >= START_INCLUSIVE.getValue()) && (number <= END_INCLUSIVE.getValue()));
    }

}
