package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Converter;

public class InputView {

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return Converter.parse(purchaseAmount);
    }
}
