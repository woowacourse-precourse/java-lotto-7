package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    @Override
    public String requestLottoPurchaseAmount() {
        return consoleInput();
    }

    @Override
    public String requestWinningLottoNumbers() {
        return consoleInput();
    }

    @Override
    public String requestWinningLottoBonusNumber() {
        return consoleInput();
    }

    private String consoleInput() {
        return Console.readLine();
    }
}
