package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final String LOTTO_NUMBER_SIZE_ERROR_MSG = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR_MSG = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static Lotto issue() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public void print() {
        System.out.println(numbers.toString());
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MSG);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR_MSG);
        }
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    // TODO: 추가 기능 구현
}
