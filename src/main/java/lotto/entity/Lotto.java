package lotto.entity;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    /**
     * 입력받은 번호 리스트의 유효성을 검사합니다.
     * - 번호는 6개여야 하며, 중복이 없어야 합니다.
     * - 각 번호는 1에서 45 사이여야 합니다.
     *
     * @param numbers 로또 번호 리스트
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }

        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }

        for (int number : numbers) {
            if (number < LottoConstants.MIN_LOTTO_NUMBER.getValue() || number > LottoConstants.MAX_LOTTO_NUMBER.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.getMessage());
            }
        }
    }
}
