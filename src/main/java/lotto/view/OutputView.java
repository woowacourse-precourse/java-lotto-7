package lotto.view;

import java.util.ArrayList;
import lotto.Lotto;

public class OutputView {

    public void printLottoInfo(int count, ArrayList<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");

        for (int i = 0; i < count; i++) {
            System.out.println(lottos.get(i).toString());
        }
    }

    public void printWinningResult() {

    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
