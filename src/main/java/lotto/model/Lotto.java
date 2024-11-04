package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import lotto.util.ErrorMessages;

public class Lotto {

    public static final Integer LOTTO_PRICE = 1000;

    public static final Integer NUMBER_MIN = 1;
    public static final Integer NUMBER_MAX = 45;
    public static final Integer NUMBER_CNT = 6;

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = genRandomNumbers();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_CNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_SIZE.getMessage());
        }
        if ((new HashSet<>(numbers)).size() != NUMBER_CNT) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
        for (int number : numbers) {
            if (number < NUMBER_MIN || number > NUMBER_MAX) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private List<Integer> genRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_MIN, NUMBER_MAX, NUMBER_CNT)
                .stream()
                .sorted()
                .toList();
    }

    public int matchNumbers(Lotto lotto) {
        return (int) this.numbers
                .stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    public boolean matchBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
}
