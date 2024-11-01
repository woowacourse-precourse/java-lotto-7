package lotto.service;

import static lotto.constants.CommonConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.CommonConstants.LOTTO_NUMBER_MAX;
import static lotto.constants.CommonConstants.LOTTO_NUMBER_MIN;
import static lotto.constants.CommonConstants.LOTTO_PRICE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.ErrorCode;
import lotto.exception.CommonException;

public class ValidatorService {

    public void validatePurchaseAmount(int amount) {
        if(amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new CommonException(ErrorCode.INVALID_PURCHASE_AMOUNT);
        }
    }

    public void validateLottoNumbers(List<Integer> numbers){
        if(numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new CommonException(ErrorCode.INVALID_LOTTO_NUMBER_COUNT);
        }
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new CommonException(ErrorCode.INVALID_NUMBER_RANGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new CommonException(ErrorCode.DUPLICATE_BONUS_NUMBER);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean hasInvalidNumber = numbers.stream()
                .anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX);

        if (hasInvalidNumber) {
            throw new CommonException(ErrorCode.INVALID_NUMBER_RANGE);
        }
    }


    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new CommonException(ErrorCode.DUPLICATE_NUMBER);
        }
    }
}
