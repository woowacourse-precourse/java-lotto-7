package lotto.model;

import java.util.List;

public class LottoDTO {
    private static final String ERROR_MESSAGE_INVALID_COUNT = "[ERROR] 로또 번호가 이어있습니다.";
    private final List<Integer> numbers;

    public LottoDTO(List<Integer> numbers) {
        if (numbers == null) {
            throw new NullPointerException(ERROR_MESSAGE_INVALID_COUNT);
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}