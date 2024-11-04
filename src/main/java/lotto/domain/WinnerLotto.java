package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.error.ErrorCode;

public class WinnerLotto extends Lotto {

    private Integer bonusNumber;

    public WinnerLotto(List<Integer> numbers) {
        super(numbers);
        this.bonusNumber = null;
    }

    public static WinnerLotto from(String winningNumbersInput) {
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(WinnerLotto::parseInt)
                .toList();
        return new WinnerLotto(winningNumbers);
    }

    public WinnerLotto addBonusNumber(String bonusNumberInput) {
        Integer bonusNumber = parseInt(bonusNumberInput);
        validateBonusNumber(bonusNumber, super.numbers);
        this.bonusNumber = bonusNumber;
        return this;
    }

    private static void validateBonusNumber(Integer bonusNumber, List<Integer> numbers) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorCode.OUT_OF_RANGE.getMessage());
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_NUMBER.getMessage());
        }
    }


    private static Integer parseInt(String number) {
        try {
            return  Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorCode.NOT_INTEGER.getMessage());
        }
    }
}
