package lotto.view;

import java.util.List;
import lotto.enums.Win;

public class Response {
    public void outputLottos(List<String> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (String lotto : lottos) {
            System.out.println("[" + lotto + "]");
        }
    }

    public void outputLottosWin(List<Integer> lottosWin) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottosWin.get(Win.LOTTO_5TH.getRank()) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottosWin.get(Win.LOTTO_4TH.getRank()) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottosWin.get(Win.LOTTO_3RD.getRank()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottosWin.get(Win.LOTTO_2ND.getRank()) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottosWin.get(Win.LOTTO_1ST.getRank()) + "개");
    }

    public void outputLottosWinningRate(Double winningsRate) {
        System.out.println("총 수익률은 " + winningsRate + "%입니다.");
    }
}
