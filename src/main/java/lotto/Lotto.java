package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;
    private static final String LOTTO_NUM_SIX_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String LOTTO_NUM_DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUM_SIX_ERROR);
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUM_DUPLICATE_ERROR);
        }
    }

    // TODO: 추가 기능 구현
    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> hashSet = new HashSet<>(numbers);
        return hashSet.size() != numbers.size();
    }

    @Override
    public String toString(){
        return numbers.toString();
    }
}
