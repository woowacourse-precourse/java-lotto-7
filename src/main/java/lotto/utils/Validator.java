package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateInputPurchaseAmount(String inputPurchaseAmount) {
        if(!isValidNumber(inputPurchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
        if(Integer.parseInt(inputPurchaseAmount) < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_TOO_LOW.getMessage());
        }
        if (Integer.parseInt(inputPurchaseAmount) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE.getMessage());
        }
    }

    public void validateInputLottoNumber(String inputLottoNumbers) {
        String[] numbers = inputLottoNumbers.split(",");
        if (numbers.length != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            validateSingleNumber(number.trim(), uniqueNumbers);
        }
    }

    private void validateSingleNumber(String number, Set<Integer> uniqueNumbers) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
        int singleNumber = Integer.parseInt(number);
        if (singleNumber < Constant.MIN_LOTTO_NUMBER || singleNumber > Constant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
        if (!uniqueNumbers.add(singleNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }


    public void validateInputBonusNumber(String inputBonusNumber, List<Integer> winningNumbers) {
        if (!isValidNumber(inputBonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }

        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (bonusNumber < Constant.MIN_LOTTO_NUMBER || bonusNumber > Constant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER_WITH_WINNING.getMessage());
        }
    }

    private boolean isValidNumber(String inputPurChaseAmount) {
        try {
            Integer.parseInt(inputPurChaseAmount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

