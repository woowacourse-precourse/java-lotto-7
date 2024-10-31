package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.GameException;
import lotto.io.request.WinningNumberRequest;

public class InputHandler {

    public int inputPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new GameException("구입 금액은 숫자여야 합니다.");
        }
    }

    public WinningNumberRequest getWinningNumbers() {
        return new WinningNumberRequest(Console.readLine());
    }
}
