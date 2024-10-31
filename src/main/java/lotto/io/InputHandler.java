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

    public int getBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new GameException("보너스 번호는 숫자여야 합니다.");
        }
    }

}
