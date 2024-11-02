package lotto.view;

import lotto.model.Lotto;
import lotto.model.PurchasedLottos;
import lotto.model.Statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachineView {
    public static void printPurchaseLottoView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchasedLottosView(PurchasedLottos purchasedLottos) {
        System.out.println(purchasedLottos.getSize() + "개를 구매했습니다.");

        StringBuilder purchasedLottoNumbers = new StringBuilder();
        for ( Lotto lotto : purchasedLottos.getLottos() ) {
            List<Integer> list = new ArrayList<>(lotto.getNumbers());
            Collections.sort(list);
            purchasedLottoNumbers.append(list).append('\n');
        }

        System.out.println(purchasedLottoNumbers);
    }

    public static void printEnterWinningNumbersView() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printEnterBonusWinningNumberView() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }


    public static void printStatisticsView(Statistics statistics) {
        int[] lottoRank = statistics.getLottoPrizeCount();
        System.out.println("당첨 통계\n---");

        System.out.println("3개 일치 (5,000원) - " + lottoRank[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoRank[4]+ "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoRank[3]+ "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoRank[2]+ "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoRank[1]+ "개");
        System.out.println("총 수익률은 " + statistics.getYield() + "%입니다.");
    }
}
