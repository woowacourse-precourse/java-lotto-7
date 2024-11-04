package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Validator {
    private static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액이 유효하지 않습니다.";
    private static final String INVALID_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호가 유효하지 않습니다.";

    public static String isValidPurchaseAmount(String purchaseAmount) {
        try {
            int canInteger = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(PURCHASE_AMOUNT_ERROR_MESSAGE);
            isValidPurchaseAmount(InputView.getPurchaseAmount());
        }
        return purchaseAmount;
    }

    public static String isValidWinningNumber(String winningNumbers) {
        try {
            List<Integer> winningNumber = Arrays.stream(winningNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(INVALID_WINNING_NUMBER_ERROR_MESSAGE);
            return isValidWinningNumber(InputView.getWinningNumber());
        }
        return winningNumbers;
    }

}
