package lotto;

import lotto.view.LottoInputView;

public class Application {
    public static void main(String[] args) {
        LottoInputView inputView = new LottoInputView();
        System.out.println("구입금액을 입력해 주세요.");
        inputView.readMoney();
    }
}