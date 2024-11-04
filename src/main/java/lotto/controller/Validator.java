package lotto.controller;

import static lotto.ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR;
import static lotto.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.ErrorMessage.NOT_NUMERIC_ERROR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class Validator {
    public static final String DELIMITER = ",";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public void validateWinningNumber(Lotto lotto){
        for(Integer i : lotto.getNumbers()){
            validateLottoNumberRange(i);
        }
    }
    public void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateLottoNumberRange(bonusNumber);
        validateDuplicateWithLottoNumber(winningNumbers,bonusNumber);
    }

    private void validateDuplicateWithLottoNumber(List<Integer> winningNumbers, int bonusNumber) {
        boolean isDuplicate = winningNumbers.stream().anyMatch(i -> i == bonusNumber);
        if (isDuplicate) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private void validateLottoNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }
    public int validateConvertToNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR.getMessage());
        }
    }

    public List<Integer> validateIsNumeric(String lottoNumbers) {
        List<String> numbers = Arrays.stream(lottoNumbers.split(DELIMITER)).toList();
        List<Integer> validateNumber = new ArrayList<>();
        for (String number : numbers) {
            validateNumber.add(validateConvertToNumber(number));
        }
        return validateNumber;
    }


}
