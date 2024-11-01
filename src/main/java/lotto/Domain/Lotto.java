package lotto.Domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 추가적인 validation을 대비해 validate 매서드 생성
    private void validate(List<Integer> numbers){
        validateSizeOfNumber(numbers);
    }

    private void validateSizeOfNumber(List<Integer> numbers) {
        final int LOTTO_SIZE = 6;
        final String LOTTO_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
}
