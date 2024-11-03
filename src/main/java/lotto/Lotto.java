package lotto;

import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private static final String IS_NOT_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        validateLottoSetSize(numbers);
    }

    private void validateLottoSetSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
