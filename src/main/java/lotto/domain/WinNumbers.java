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

    public static WinNumbers winNumbersFrom(String originWinNumbers) {
        List<String> numbers = Arrays.stream(originWinNumbers.split(",")).toList();
        List<Integer> extractWinNumbers = new ArrayList<>();
        for (String number : numbers) {
            try {
                extractWinNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_EXCEPTION.getMessage());
            }
        }
        Validator.validatedNumberCount(extractWinNumbers);
        Validator.validateDuplicate(extractWinNumbers);
        return new WinNumbers(extractWinNumbers, null);
    }

    public WinNumbers bonusNumberFrom(String bonusNumber) {
        int convertBonusNumber;
        try {
            convertBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_EXCEPTION.getMessage());
        }
        if (primaryWinNumbers.contains(convertBonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_EXIST_EXCEPTION.getMessage());
        }
        return new WinNumbers(primaryWinNumbers, convertBonusNumber);
    }
}
