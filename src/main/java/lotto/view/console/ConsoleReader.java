package lotto.view.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BonusNumberRequest;
import lotto.dto.PurchaseAmountRequest;
import lotto.dto.WinningNumbersRequest;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumbersValidator;
import lotto.view.InputView;

public class ConsoleReader implements InputView {
    private static final String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";

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

    @Override
    public WinningNumbersRequest readWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_REQUEST_MESSAGE);
        try {
            String winningNumbers = readAndTrimInput();
            WinningNumbersValidator.validate(winningNumbers);
            return WinningNumbersRequest.from(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumbers();
        }
    }

    @Override
    public BonusNumberRequest readBonusNumber(WinningNumbersRequest winningNumbersRequest) {
        System.out.println();
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
        try {
            String bonusNumber = readAndTrimInput();
            BonusNumberValidator.validate(bonusNumber, winningNumbersRequest.getWinningNumbers());
            return BonusNumberRequest.from(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(winningNumbersRequest);
        }
    }


    private String readAndTrimInput() {
        return Console.readLine().trim();
    }
}
