package lotto.view;

import lotto.domain.Lotto;

public class OutputView {

    public void printError(String message) {
        System.out.println(message);
    }

    public void printPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}