package lotto.domain;

import static lotto.domain.LottoInfo.END_NUMBER;
import static lotto.domain.LottoInfo.START_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String NUMBER_OUT_OF_RANGE = "[ERROR] 로또 번호의 숫자 범위를 벗어납니다.";
    private static final String NUMBER_DUPLICATED = "[ERROR] 번호에 중복이 존재합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            checkNumberRange(number);
        }
        checkNumberDuplicated(numbers);
    }

    // TODO: 추가 기능 구현
    public void showNumbers() {
        System.out.println(numbers);
    }

    public static void checkNumberRange(int number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }
    }

    static void checkNumberDuplicated(List<Integer> validRangeNumbers) {
        Set<Integer> distinctNumbers = new HashSet<>(validRangeNumbers);
        if (distinctNumbers.size() != validRangeNumbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
