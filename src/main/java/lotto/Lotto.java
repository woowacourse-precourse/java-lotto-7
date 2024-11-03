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

        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_MUST_NOT_DUPLICATE.getMessage());
        }
    }

    public static Lotto createRandomLotto(){

        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUM, LOTTO_FINAL_NUM, LOTTO_SIZE));
    }

    public static Lotto createWinningRegularLotto(String numbers){

        try{
            List<Integer> winningNumber = Arrays.stream(numbers.split(","))
                    .map(String::trim)  // 각 숫자 문자열의 앞뒤 공백 제거
                    .map(Integer::parseInt)  // 문자열을 Integer로 변환
                    .toList();

            return new Lotto(winningNumber);

        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorCode.CANT_CONVERT_TO_INTEGER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
