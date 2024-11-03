package lotto.view;

import lotto.message.Message;
import java.math.BigInteger;

public class OutputView {
    public void printLottoAmount(BigInteger purchaseAmount) {
        System.out.println(purchaseAmount + Message.PURCHASE_AMOUNT_MESSAGE.getMessage());
    }
}
