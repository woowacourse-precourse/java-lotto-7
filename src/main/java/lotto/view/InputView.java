package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import lotto.utils.Utils;
import net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation;

public class InputView {

    //inputPurchasePrice 구현
    public static int inputPurchasePrice() {
        String userInput;
        int count;

        userInput = Console.readLine();
        count = Utils.stringToInteger(userInput);
        return count;
    }

    //금액 valiadate 구현

    //inputWinningNumber 구현

    //inputBonusNumber 구현
}
