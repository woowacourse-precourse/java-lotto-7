package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final String LOTTO_NUMBER_SIZE_ERROR_MSG = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR_MSG = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        /*
         * toList()의 반환 타입은 Collections.unmodifiableList 이다.
         * 따라서 numbers에 대한 getter를 열어두어도 불변성을 보장한다.
         * */
        this.numbers = numbers.stream().sorted().toList();
    }

    public static Lotto issue() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
