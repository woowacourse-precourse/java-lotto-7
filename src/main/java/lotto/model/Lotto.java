package lotto.model;

import java.util.List;
import lotto.enums.LottoBoundInfo;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateIsUnique(numbers);
        validateIsElementInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoBoundInfo.LOTTO_NUMBER_COUNT.getInfo()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateIsElementInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > LottoBoundInfo.MAXIMUM_NUMBER.getInfo() || number < LottoBoundInfo.MINIMUM_NUMBER.getInfo()) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이여야 합니다.");
            }
        }
    }

    private void validateIsUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoBoundInfo.LOTTO_NUMBER_COUNT.getInfo()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
