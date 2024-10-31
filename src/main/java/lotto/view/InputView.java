package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;

public class InputView {

    public PurchaseAmount readPurchasePrice() {
        String input = Console.readLine();
        return new PurchaseAmount(Integer.parseInt(input));
    }
}
