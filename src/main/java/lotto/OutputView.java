package lotto;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_CONFIRM = "개를 구매했습니다.";

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASE_CONFIRM);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningsResult() {
        System.out.println("당첨 통계\n---");
        WinningRank.printWinningsResult();
    }

    public void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningRate);
    }
}
