package lotto.validate;

import lotto.LottoConstants;

import java.util.List;

public class ValidateInput {
    public static int validateAmount(String amountInput) {
        int amount = validateNumeric(amountInput);

        if (amount % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }

        return amount;
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 6개의 중복되지 않는 숫자를 입력해야 합니다.");
        }

        winningNumbers.forEach(ValidateInput::validateNumberInRange);
    }

    public static int validateBonusNumber(String inputBonusNumber) {
        int bonusNumber = validateNumeric(inputBonusNumber);

        validateNumberInRange(bonusNumber);

        return bonusNumber;
    }

    private static int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < LottoConstants.MIN_NUMBER.getValue() || number > LottoConstants.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이여야 합니다.");
        }
    }
}
