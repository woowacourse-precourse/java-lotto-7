package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private static final String IS_NOT_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String IS_DUPLICATE_NUMBER = "[ERROR] 중복된 번호가 있습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        validateLottoSetSize(numbers);
        valdiateDuplicate(numbers);
    }

    private void valdiateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(IS_DUPLICATE_NUMBER);
        }
    }

    private void validateLottoSetSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_SIZE);
        }
    }

    // TODO: 추가 기능 구현
}
