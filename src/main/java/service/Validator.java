package service;

import exception.ErrorCode;
import model.Lotto;

import java.util.List;

import static service.Constants.*;

public class Validator {

    public int validateAmountNumber(String inputPurchaseAmount){
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT_NUMBER.getErrorMessage());
        }
    }

    public void validateAmountCount(int amount){
        if (amount%1000 != 0){
            throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT_UNIT.getErrorMessage());
        }
    }

    public void validateLottoCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorCode.RESTRICTION_WINNING_NUMBER.getErrorMessage());
        }
    }

    public void validateDuplicatedWinningNumber(List<Integer> numbers){
        numbers.forEach(this::validateNumberRange);
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_WINNING_NUMBER.getErrorMessage());
        }
    }

    public void validateDuplicatedBonusNumber(int bonusNumber, Lotto lotto){
        validateNumberRange(bonusNumber);
        if(lotto.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }

    public void validateNumberRange(int bonusNumber){
        if(bonusNumber < LOTTO_MIN || bonusNumber > LOTTO_MAX){
            throw new IllegalArgumentException(ErrorCode.NUMBER_RANGE_LIMITATION.getErrorMessage());
        }
    }

    public void validateDelimiter(String winningNumber){
        if (!winningNumber.matches(REGEX)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_DELIMITER.getErrorMessage());
        }
    }

    public void validateEmpty(Object input) {
        if (input == null || (input instanceof String && ((String) input).trim().isEmpty())) {
            throw new IllegalArgumentException(ErrorCode.INPUT_EMPTY.getErrorMessage());
        }
    }
}
