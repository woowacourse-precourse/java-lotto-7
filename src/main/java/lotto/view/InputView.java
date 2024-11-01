package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.PurchaseAmountDto;

public class InputView {

    public PurchaseAmountDto readPurchaseAmount() {
        String input = Console.readLine();
        return new PurchaseAmountDto(input.trim());
    }
}
