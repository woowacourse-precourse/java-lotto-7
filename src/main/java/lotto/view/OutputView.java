package lotto.view;

import lotto.domain.Lotto;

public class OutputView {
    public static void printLottoAmount(int amount) {
        System.out.println("\n" + amount + "개를 구매했습니다.");
    }

    public static void printEachLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}
