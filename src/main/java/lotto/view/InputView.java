package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.MoneyRequest;
import lotto.dto.request.WinningNumbersRequest;

public class InputView {

    private InputView() {
    }

    public static MoneyRequest money() {
        return MoneyRequest.from(input());
   }

    public static WinningNumbersRequest winningNumbers() {
        return WinningNumbersRequest.from(input());
    }

    public static BonusNumberRequest bonusNumber() {
        return BonusNumberRequest.from(input());
    }

    private static String input() {
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }
}
