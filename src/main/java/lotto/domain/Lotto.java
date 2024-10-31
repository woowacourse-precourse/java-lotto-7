package lotto.domain;

import java.util.Comparator;
import java.util.List;
import lotto.constant.LotteryConst;
import lotto.exception.ExceptionMessages;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersAmount(numbers);
        validateDuplicatedElemExist(numbers);
        validateOutOfRangeNumber(numbers);
    }

    private void validateNumbersAmount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicatedElemExist(List<Integer> numbers) {
        long duplicatedCount = numbers.stream().distinct().count();
        if (duplicatedCount != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessages.DUPLICATED_NUMBER_EXIST.getMessage());
        }
    }

    private void validateOutOfRangeNumber(List<Integer> numbers) {
        Integer maxVal = numbers.stream()
                .max(Comparator.comparing(x -> x))
                .orElseThrow();

        Integer minVal = numbers.stream()
                .min(Comparator.comparing(x -> x))
                .orElseThrow();

        if (maxVal > LotteryConst.MAX.getValue() || minVal < LotteryConst.MIN.getValue()) {
            throw new IllegalArgumentException(ExceptionMessages.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
