package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class LottoValidator {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void validateWinningNumbers(List<Integer> numbers){
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new LottoException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT);
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new LottoException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }

        if (numbers.stream().anyMatch(n -> n < LOTTO_MIN_NUMBER || n > LOTTO_MAX_NUMBER)) {
            throw new LottoException(ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER);
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new LottoException(ErrorMessage.OUT_OF_RANGE_BONUS_NUMBER);
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new LottoException(ErrorMessage.DUPLICATE_BONUS_NUMBER);
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new LottoException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT);
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new LottoException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }

        if (numbers.stream().anyMatch(num -> num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER)) {
            throw new LottoException(ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER);
        }
    }
}
