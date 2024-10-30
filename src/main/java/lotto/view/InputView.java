package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.PurchaseMoneyRequest;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public PurchaseMoneyRequest readMoneyInput() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String moneyInput = Console.readLine();
        return new PurchaseMoneyRequest(moneyInput);
    }
}
