package lotto.view.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.PurchaseAmountRequest;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.view.InputView;

public class ConsoleReader implements InputView {
    private static final String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";

    @Override
    public PurchaseAmountRequest readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
        try {
            String purchaseAmount = readAndTrimInput();
            InputValidator.validatePurchaseAmount(purchaseAmount);
            return PurchaseAmountRequest.from(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }

    private String readAndTrimInput() {
        return Console.readLine().trim();
    }

    private static class InputValidator {
        private static final int MAX_AMOUNT = 100000;
        private static final String VALID_AMOUNT_PATTERN = "^[1-9]\\d*000$";

        private static void validatePurchaseAmount(String purchaseAmount) {
            validatePurchaseAmountNotNull(purchaseAmount);
            validatePurchaseAmountNotEmpty(purchaseAmount);
            validatePurchaseAmountPattern(purchaseAmount);
            validateMaxPurchaseAmount(purchaseAmount);
        }

        private static void validatePurchaseAmountNotNull(String purchaseAmount) {
            if (purchaseAmount == null) {
                throw LottoException.from(ErrorMessage.NULL_INPUT_ERROR);
            }
        }

        private static void validatePurchaseAmountNotEmpty(String purchaseAmount) {
            if (purchaseAmount.isBlank()) {
                throw LottoException.from(ErrorMessage.EMPTY_INPUT_ERROR);
            }
        }

        private static void validatePurchaseAmountPattern(String purchaseAmount) {
            if (!purchaseAmount.matches(VALID_AMOUNT_PATTERN)) {
                throw LottoException.from(ErrorMessage.INVALID_AMOUNT_PATTERN_ERROR);
            }
        }

        private static void validateMaxPurchaseAmount(String purchaseAmount) {
            if (parsePurchaseAmountToInt(purchaseAmount) > MAX_AMOUNT) {
                throw LottoException.from(ErrorMessage.MAX_AMOUNT_ERROR);
            }
        }

        private static int parsePurchaseAmountToInt(String amountStr) {
            return Integer.parseInt(amountStr);
        }
    }
}
