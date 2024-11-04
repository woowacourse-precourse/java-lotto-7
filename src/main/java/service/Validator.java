package service;

import exception.Exception;
import model.Lotto;

import java.util.List;

import static service.Constants.*;

public class Validator {

    public int validateNumber(String inputPurchaseAmount){
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exception.INVALID_NUMBER.getMessage());
        }
    }

    public void validateAmountCount(int amount){
        if (amount%1000 != 0){
            throw new IllegalArgumentException(Exception.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }

    public void validateLottoCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(Exception.RESTRICTION_WINNING_NUMBER.getMessage());
        }
    }

    public void validateDuplicatedWinningNumber(List<Integer> numbers){
        numbers.forEach(this::validateNumberRange);
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(Exception.DUPLICATED_WINNING_NUMBER.getMessage());
        }
    }

    public void validateDuplicatedBonusNumber(int bonusNumber, Lotto lotto){
        validateNumberRange(bonusNumber);
        if(lotto.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(Exception.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public void validateNumberRange(int bonusNumber){
        if(bonusNumber < LOTTO_MIN || bonusNumber > LOTTO_MAX){
            throw new IllegalArgumentException(Exception.NUMBER_RANGE_LIMITATION.getMessage());
        }
    }

    public void validateDelimiter(String winningNumber){
        if (!winningNumber.matches(REGEX)) {
            throw new IllegalArgumentException(Exception.INVALID_DELIMITER.getMessage());
        }
    }

    public void validateEmpty(Object input) {
        if (input == null || (input instanceof String && ((String) input).trim().isEmpty())) {
            throw new IllegalArgumentException(Exception.INPUT_EMPTY.getMessage());
        }
    }
}