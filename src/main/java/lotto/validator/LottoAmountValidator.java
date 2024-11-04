package lotto.validator;

import lotto.message.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoAmountValidator {
    public static int validatePurchaseAmout(String lottoAmount) {
        inputNullOrEmpty(lottoAmount);
        int lottoRound = convertPurchaseAmountToInt(lottoAmount);
        if (lottoRound % 1000 != 0) {
            handleAmountNotDivisibleBy1000();
        }
        if (lottoRound < 1000) {
            handleAmountLessThan1000();
        }
        return lottoRound / 1000;
    }

    private static void handleAmountNotDivisibleBy1000() {
        try {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.buyLotto();
        }
    }

    private static void handleAmountLessThan1000() {
        try {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE_OR_ZERO.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.buyLotto();
        }
    }

    private static int convertPurchaseAmountToInt(String lottoInteger) {
        int lottoRound = 0;
        try {
            lottoRound = Integer.parseInt(lottoInteger);
        } catch (NumberFormatException e) {
            handleNumberFormatExecption();
        }
        return lottoRound;
    }

    private static void handleNumberFormatExecption(){
        try {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
        catch(IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.buyLotto();
        }
    }


    public static void inputNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            handleNullOrEmpty();
        }
    }

    public static void handleNullOrEmpty() {
        try {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL_OR_EMPTY.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.buyLotto();
        }
    }
}
