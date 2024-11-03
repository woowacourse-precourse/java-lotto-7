package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.RequestMessage;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println(RequestMessage.REQUEST_LOTTO_PURCHASE_AMOUNT.getMessage());
        return Integer.parseInt(Console.readLine().trim());
    }
}
