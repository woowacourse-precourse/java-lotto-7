package lotto.view;

import static lotto.constant.LottoInfoMsg.INPUT_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getMsg());
        return Console.readLine();
    }
}
