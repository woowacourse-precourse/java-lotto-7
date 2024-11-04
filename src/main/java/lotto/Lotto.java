package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.exception.ErrorCode;

public class Lotto {
    private final List<Integer> numbers;

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_FINAL_NUM = 45;

    private static final String DEFAULT_DELIM = ",";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_COUNT_MUST_BE_SIX.getMessage());
        }

        if (!numbers.stream().allMatch(num -> num >= LOTTO_START_NUM && num <= LOTTO_FINAL_NUM)) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }

        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_LOTTO_NUMBERS_NOT_ALLOWED.getMessage());
        }
    }

    public static Lotto createRandomLotto(){

        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUM, LOTTO_FINAL_NUM, LOTTO_SIZE));
    }

    public static Lotto createWinningRegularLotto(String numbers){

        try{
            List<Integer> winningNumber = Arrays.stream(numbers.split(DEFAULT_DELIM))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

            return new Lotto(winningNumber);

        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorCode.FAILED_TO_PARSE_INTEGER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}