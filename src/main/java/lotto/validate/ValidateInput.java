package lotto.validate;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.validate.LottoConstants.LOTTO_PRICE;
import static lotto.validate.LottoConstants.MIN_VALID_AMOUNT;

public class ValidateInput {
    public static int validateAmount(String amountInput) {
        int amount = validateNumeric(amountInput);

        if (amount < MIN_VALID_AMOUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }

        if (amount % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }

        return amount;
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != new HashSet<>(winningNumbers).size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }

        winningNumbers.forEach(ValidateInput::validateNumberInRange);
    }

    public static int validateBonusNumber(String inputBonusNumber, Lotto winningLotto) {
        int bonusNumber = validateNumeric(inputBonusNumber);
        validateNumberInRange(bonusNumber);

        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

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
