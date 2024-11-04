package lotto.io;

import static lotto.constant.PrintMessageConstants.PURCHASE_COUNT;

import java.util.List;
import java.util.Map;
import lotto.lotto.object.Lotto;
import lotto.lotto.object.MyLotto;

public class OutputHandler {
    public void printPrompt(String message) {
        System.out.println(message);
    }

    public void printPurchasedLotto(List<MyLotto> lottos) {
        System.out.println(lottos.size() + PURCHASE_COUNT);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(Map<Integer, Integer> count) {
        System.out.println(
                "3개 일치 (5,000원) - " + count.get(5) + "개\n"
                        + "4개 일치 (50,000원) - " + count.get(4) + "개\n"
                        + "5개 일치 (1,500,000원) - " + count.get(3) + "개\n"
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + count.get(2) + "개\n"
                        + "6개 일치 (2,000,000,000원) - " + count.get(1) + "개"
        );
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printReturnRate(double rate) {
        rate = rate * 100;
        rate = Math.round(rate * 100) / 100.0;
        System.out.printf("총 수익률은 " + rate + "%%입니다.", rate);
    }

    public void printLineBreak() {
        System.out.println();
    }
}
