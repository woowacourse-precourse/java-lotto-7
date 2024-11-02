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
     *
     * @param numbers 로또 번호 리스트
     */
    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers);
    }

    /**
     * 번호가 6개인지 검사합니다.
     *
     * @param numbers 로또 번호 리스트
     */
    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
    }

    /**
     * 번호 리스트에 중복된 번호가 없는지 검사합니다.
     *
     * @param numbers 로또 번호 리스트
     */
    private void validateNoDuplicates(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    /**
     * 번호가 1에서 45 사이에 있는지 검사합니다.
     *
     * @param numbers 로또 번호 리스트
     */
    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConstants.MIN_LOTTO_NUMBER.getValue() || number > LottoConstants.MAX_LOTTO_NUMBER.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.getMessage());
            }
        }
    }

    /**
     * 당첨 번호와 일치하는 숫자 개수를 반환합니다.
     *
     * @param winningNumbers 당첨 번호 리스트
     * @return 일치하는 숫자 개수
     */
    public int countMatchingNumbers(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
