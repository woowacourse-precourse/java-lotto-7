package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_OF_NUMBERS = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto quickPick() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_OF_NUMBERS));
    }

    private void validate(List<Integer> numbers) {
        validateExactlySix(numbers);
        validateUnduplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateExactlySix(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_HAVE_A_SIX_NUMBERS.message());
        }
    }

    private static void validateUnduplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE_NUMBER.message());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(this::isLottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_OUT_OF_RANGE.message());
        }
    }

    private boolean isLottoNumber(int number) {
        return (number >= MIN_NUMBER) && (number <= MAX_NUMBER);
    }

}
