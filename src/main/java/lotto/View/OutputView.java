package lotto.View;

import lotto.Lotto;

import java.util.List;

public class OutputView {

    public void printPurchasedLotto(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printWinningStat() {
        System.out.println("당첨 통계");
        System.out.println("---");

    }
}
