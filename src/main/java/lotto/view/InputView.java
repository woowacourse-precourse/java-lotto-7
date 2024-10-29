package lotto.view;

import lotto.model.Money;
import lotto.util.InputUtil;

public class InputView {

    public Money getPurchaseAmountFromUser() {
        return Money.of(InputUtil.readInt());
    }

}
