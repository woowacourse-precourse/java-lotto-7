package lotto.domain;

import java.util.List;

public class Lotto {

    private static final Integer LOTTO_NUMBER_COUNT = 6;
    private static final Integer MIN_NUMBER_RANGE = 1;
    private static final Integer MAX_NUMBER_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateNumberDuplication(numbers);
        this.numbers = sortNumber(numbers);
    }

    public static Lotto create(List<Integer> number) {
        return new Lotto(number);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::IsNumberRangeIncorrect)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean IsNumberRangeIncorrect(Integer number) {
        return number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE;
    }

    private void validateNumberDuplication(List<Integer> numbers) {
        if (IsNumberDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean IsNumberDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().toList()
                .size() != numbers.size();
    }

    private List<Integer> sortNumber(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
