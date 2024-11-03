package lotto.io;

import lotto.Lotto;

public class OutputHandler {

    public void showPurchaseCostInputComments() {
        System.out.println("구입금액을 입력해주세요.");
    }

    public void showErrorMessage(String message) {
        System.err.println(message);
    }

    public void showPurchaseLottoCount(Integer purchaseCost) {
        System.out.println(purchaseCost / 1000 + "개를 구매했습니다.");
    }

    public void showNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
