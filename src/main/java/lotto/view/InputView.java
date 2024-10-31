package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Parser;

public class InputView {
    public String InputPurchaseAmount() {
        String inputCost = Console.readLine();
        return inputCost;
    }
}
