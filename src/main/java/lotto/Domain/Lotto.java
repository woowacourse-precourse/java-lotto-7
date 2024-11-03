package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Messages.ErrorMessage;

public class Lotto {
    private static final int start = 1;
    private static final int end = 45;
    private static final int count = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 아래부터 추가 기능 구현
    public static Lotto create() {
        List<Integer> numbers = generateNumbers();
        return new Lotto(numbers);
    }

    public static Lotto from(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplicate(numbers);
        return new Lotto(numbers);
    }

    private static List<Integer> generateNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(start, end, count);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(start <= number
                    && number <= end)) {
                String message = String.format(ErrorMessage.RANGE_OUT_NUMBERS.getMessage(), start, end);
                throw new IllegalArgumentException(message);
            }
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getMessage());
        }
    }


}
