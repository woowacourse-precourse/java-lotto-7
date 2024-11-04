package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;
import lotto.exception.GameException;
import lotto.io.request.WinningNumberRequest;

public class InputHandler {

    public int inputPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new GameException(ErrorMessage.NUMBER_FORMAT);
        }
    }

    public WinningNumberRequest getWinningNumbers() {
        return new WinningNumberRequest(Console.readLine());
    }

    public int getBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new GameException(ErrorMessage.NUMBER_FORMAT);
        }
    }

}
