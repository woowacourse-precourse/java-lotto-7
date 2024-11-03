package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    OutputView outputView = new OutputView();
    public String readLine() {
        return Console.readLine();
    }
    public String requestPurchaseAmount () {
        outputView.printRequestPurchaseAmount();
        return readLine();
    }
    public String requestWinningNumbers () {
        outputView.printRequestWinningNumbers();
        return readLine();
    }
    public String requestBonusNumber () {
        outputView.printRequestBonusNumber();
        return readLine();
    }
}
