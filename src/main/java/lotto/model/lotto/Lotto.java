package lotto.model.lotto;

import static lotto.model.util.constant.LottoConstants.LOTTO_SIZE;
import static lotto.model.util.constant.LottoConstants.MAX_NUMBER;
import static lotto.model.util.constant.LottoConstants.MIN_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final String INVALID_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String INVALID_DUPLICATION_MASSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    private static final String INVALID_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private static final String DISPLAY_LOTTO_HEADER = "[";
    private static final String DISPLAY_LOTTO_FOOTER = "]";
    private static final String DISPLAY_LOTTO_DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicationNumber(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    private void validateDuplicationNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATION_MASSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if ( number < MIN_NUMBER || number > MAX_NUMBER ) {
                throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
            }
        });
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int countSameNumber(Lotto lotto) {
        int count = 0;
        for (Integer number : numbers) {
            if(lotto.isContain(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return DISPLAY_LOTTO_HEADER +
                numbers.stream()
                        .sorted()
                        .map(Object::toString)
                        .collect(
                                Collectors.joining(DISPLAY_LOTTO_DELIMITER)
                        )
                + DISPLAY_LOTTO_FOOTER;
    }

}
