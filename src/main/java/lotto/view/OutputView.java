package lotto.view;

import lotto.model.LottoBundle;

public class OutputView {
    public static void printPurchaseAmount(Integer amount) {
        System.out.println("\n" + amount + "개를 구매했습니다.");
    }

    public static void printAllLottosNumbers(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.toString());
    }
}
