package lotto.view;

import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_TYPE;
import static lotto.exception.ErrorMessage.INVALID_PURCHASE_TYPE;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoException;

public final class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int getPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String amount = Console.readLine().trim();
        InputValidator.validatePurchaseAmountType(amount);
        return Integer.parseInt(amount);
    }

    public static String getWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine().trim();
    }

    public static int getBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine().trim();
        InputValidator.validateBonusNumberType(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static class InputValidator {
        private static void validatePurchaseAmountType(String amount) {
            if (!amount.matches("\\d+")) {
                throw new LottoException(INVALID_PURCHASE_TYPE);
            }
        }

        private static void validateBonusNumberType(String number) {
            if (!number.matches("\\d+")) {
                throw new LottoException(INVALID_BONUS_NUMBER_TYPE);
            }
        }
    }
}
