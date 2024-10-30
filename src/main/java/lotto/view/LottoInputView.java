package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {
    public String getLottoPurchaseMoney() {
        printLottoPurchaseMessage();
        return null;
    }

    private void printLottoPurchaseMessage() {
        System.out.println("구입 금액을 입력해주세요");
    }
}
