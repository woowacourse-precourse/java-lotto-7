package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.exception.ErrorCode;

public class Lotto {
    private final List<Integer> numbers;

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_FINAL_NUM = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_SIZE_MUST_BE_SIX.getMessage());
        }

        if (!numbers.stream().allMatch(num -> num >= LOTTO_START_NUM && num <= LOTTO_FINAL_NUM)) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_MUST_BE_IN_CORRECT_RANGE.getMessage());
        }
    }

    public static Lotto createRandomLotto(){

        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUM, LOTTO_FINAL_NUM, LOTTO_SIZE));
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
