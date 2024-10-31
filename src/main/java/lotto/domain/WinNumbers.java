package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.ExceptionMessage;
import lotto.Validator;

public record WinNumbers(
        List<Integer> primaryWinNumbers,
        Integer bonusWinNumber
) {

    private static final String SEPARATOR = ",";

    public static WinNumbers winNumbersFrom(String originWinNumbers) {
        List<String> numbers = Arrays.stream(originWinNumbers.split(SEPARATOR)).toList();
        validateWinNumbersCanChange(numbers);
        List<Integer> extractWinNumbers = convertWinNumbers(numbers);
        validateWinNumbers(extractWinNumbers);
        return new WinNumbers(extractWinNumbers, null);
    }

    private static void validateWinNumbersCanChange(List<String> numbers) {
        for (String number : numbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_EXCEPTION.getMessage());
            }
        }
    }

    private static List<Integer> convertWinNumbers(List<String> numbers) {
        List<Integer> extractWinNumbers = new ArrayList<>();
        for (String number : numbers) {
            extractWinNumbers.add(Integer.parseInt(number));
        }
        return extractWinNumbers;
    }

    private static void validateWinNumbers(List<Integer> extractWinNumbers) {
        Validator.validateNumberRange(extractWinNumbers);
        Validator.validateNumberCount(extractWinNumbers);
        Validator.validateDuplicate(extractWinNumbers);
    }

    public WinNumbers bonusNumberFrom(String bonusNumber) {
        int convertBonusNumber;
        try {
            convertBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_EXCEPTION.getMessage());
        }
        validateBonusNumber(convertBonusNumber);
        return new WinNumbers(primaryWinNumbers, convertBonusNumber);
    }

    private void validateBonusNumber(int convertBonusNumber) {
        if (primaryWinNumbers.contains(convertBonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_EXIST_EXCEPTION.getMessage());
        }
        if (convertBonusNumber < 1 || convertBonusNumber > 45) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }
}
