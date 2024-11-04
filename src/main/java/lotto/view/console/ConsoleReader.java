package lotto.view.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.PurchaseAmountRequest;
import lotto.dto.WinningNumbersRequest;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumbersValidator;
import lotto.view.InputView;

public class ConsoleReader implements InputView {
    private static final String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";

    @Override
    public PurchaseAmountRequest readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
        try {
            String purchaseAmount = readAndTrimInput();
            PurchaseAmountValidator.validate(purchaseAmount);
            return PurchaseAmountRequest.from(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }

    private String readAndTrimInput() {
        return Console.readLine().trim();
    }
}
