package lotto.view;

import lotto.message.Message;
import java.math.BigInteger;

public class OutputView {
    public void printLottoAmount(BigInteger purchaseMoney) {
        System.out.println(purchaseMoney.divide(BigInteger.valueOf(1000L)) + Message.PURCHASE_AMOUNT_MESSAGE.getMessage());
    }
}
