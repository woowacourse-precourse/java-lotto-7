package view.console;

import camp.nextstep.edu.missionutils.Console;
import dto.PurchaseAmountRequest;
import exception.ErrorMessage;
import exception.LottoException;
import view.InputView;

public class ConsoleReader implements InputView {
    private static final String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";

    @Override
    public PurchaseAmountRequest readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
        try {
            String purchaseAmount = readAndTrimInput();
            InputValidator.validatePurchaseAmount(purchaseAmount);
            return new PurchaseAmountRequest(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }

    private String readAndTrimInput() {
        return Console.readLine().trim();
    }

    private static class InputValidator {
        private static void validatePurchaseAmount(String purchaseAmount) {
            validateNotNull(purchaseAmount);
            validateNotEmpty(purchaseAmount);
        }

        private static void validateNotNull(String purchaseAmount) {
            if (purchaseAmount == null) {
                throw LottoException.from(ErrorMessage.NULL_INPUT_ERROR);
            }
        }

        private static void validateNotEmpty(String purchaseAmount) {
            if (purchaseAmount.isBlank()) {
                throw LottoException.from(ErrorMessage.EMPTY_INPUT_ERROR);
            }
        }
    }
}
