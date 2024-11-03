package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.InvalidWinningNumbersException;

import static lotto.exception.ErrorMessage.EMPTY_INPUT_IS_NOT_POSSIBLE;
import static lotto.exception.ErrorMessage.INVALID_NUMBER_FORMAT;

public class InputView {
    public int getPurchaseAmount() {
        System.out.println("\n" + "구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new InvalidPurchaseAmountException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public String getWinningNumber() {
        System.out.println("\n" + "당첨 번호를 입력해 주세요.");

        String winningString = Console.readLine();
        checkEnteredWinningStringIsValid(winningString);

        return winningString;
    }

    public int getBonusNumber() {
        System.out.println("\n" + "보너스 번호를 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new InvalidBonusNumberException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void checkEnteredWinningStringIsValid(String winningString) {
        if (winningString.isEmpty()) {
            throw new InvalidWinningNumbersException(EMPTY_INPUT_IS_NOT_POSSIBLE.getMessage());
        }
    }
}
