package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.global.exception.CustomException;
import lotto.global.message.ErrorMessage;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto() {
        List<Integer> numbers = generateNumbers();
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validateNumber(int number) {
        validateUniqueNumber(number);
        validateNumberRange(number);
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
        return numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateUniqueNumbers(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw CustomException.of(ErrorMessage.INVALID_LOTTO_COUNT);
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw CustomException.of(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private void validateUniqueNumber(int number) {
        if (numbers.contains(number)) {
            throw CustomException.of(ErrorMessage.DUPLICATE_BONUS_NUMBER_WITH_WINNING_NUMBER);
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw CustomException.of(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
