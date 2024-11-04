package lotto.validation;

import lotto.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.Constant.*;

public class LottoNumberValidator {
    /**
     * 당첨 번호 검증
     * @param numbers 당첨 번호
     */
    public static void validateLottoNumbers(List<Integer> numbers) {
        checkLottoNumberSize(numbers);
        checkLottoNumbersRange(numbers);
        checkNoDuplicate(numbers);
    }

    /**
     * 보너스 번호 검증
     * @param numbers 보너스 번호
     */
    public static void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        checkNumberRange(bonusNumber);
        checkNotDuplicateWithLottoNumbers(bonusNumber, numbers);
    }

    /**
     * 당첨 번호가 6개를 초과하는지 검증
     * @param numbers 당첨 번호
     */
    private static void checkLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    /**
     * 당첨 번호가 1 ~ 45 사이에 존재하는지 검증
     * @param numbers 당첨 번호
     */
    private static void checkLottoNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkNumberRange(number);
        }
    }

    private static void checkNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    /**
     * 당첨 번호가 중복되는지 검증
     * @param numbers 당첨 번호
     */
    private static void checkNoDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    /**
     * 보너스 번호가 당첨 번호와 중복되는지 검증
     * @param numbers 당첨 번호
     */
    private static void checkNotDuplicateWithLottoNumbers(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

}
