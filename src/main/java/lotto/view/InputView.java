package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String requestMoney() {
        OutputView.printRequestMoney();
        return Console.readLine();
    }

    public static String requestLottoWinningNumbers() {
        OutputView.printRequestLottoWinningNumbers();
        return Console.readLine();
    }

    public static String requestLottoBonusNumber() {
        OutputView.printRequestLottoBonusNumber();
        return Console.readLine();
    }

    public static void endRequest() {
        Console.close();
    }
}
