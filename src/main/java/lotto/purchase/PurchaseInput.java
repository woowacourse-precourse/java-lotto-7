package lotto.purchase;

import camp.nextstep.edu.missionutils.Console;

class PurchaseInput {

    private static final String PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public String getMoney() {
        System.out.println(PURCHASE_INPUT_MESSAGE);
        return Console.readLine();
    }
}
