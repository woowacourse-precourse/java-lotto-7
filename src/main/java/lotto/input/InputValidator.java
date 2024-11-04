package lotto.input;

import lotto.domain.Lotto;
import lotto.domain.LottoConstants;
import lotto.error.ErrorMessage;

public class InputValidator {

    public static void validateAmount(String input) {
        validateAmountFormat(input);

        int amount = Integer.parseInt(input);
        validateAmountMinimum(amount);
        validateAmountUnit(amount);
    }

    public static void validateWinningNumbers(String input) {
        validateWinningNumberFormat(input);
    }

    public static void validateBonusNumber(String input, Lotto winningLotto) {
        validateBonusNumberFormat(input);

        int bonusNumber = Integer.parseInt(input);
        validateBonusNumberRangeAndDuplication(bonusNumber, winningLotto);
    }

    private static void validateAmountFormat(String input) {
        // 숫자 이외의 문자가 포함된 경우
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
        }
    }

    private static void validateAmountMinimum(int amount) {
        // 구입 금액이 로또 가격(1,000원)보다 작은 경우
        if (amount < LottoConstants.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_TOO_LOW.getMessage());
        }
    }

    private static void validateAmountUnit(int amount) {
        // 구입 금액이 로또 가격(1,000원)의 배수가 아닌 경우
        if (amount % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_UNIT.getMessage());
        }
    }

    private static void validateWinningNumberFormat(String input) {
        // 숫자, ',', 공백 이외의 문자가 포함되어 있는 경우
        if (!input.matches("^[\\d,\\s]+$")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateBonusNumberFormat(String input) {
        // 숫자 이외의 문자가 포함되어 있는 경우
        if (!input.matches("^\\d+$")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateBonusNumberRangeAndDuplication(int bonusNumber, Lotto winningLotto) {
        // 보너스 번호의 범위가 올바르지 않거나 당첨 번호와 중복된 경우
        winningLotto.validateBonusNumber(bonusNumber);
    }
}
