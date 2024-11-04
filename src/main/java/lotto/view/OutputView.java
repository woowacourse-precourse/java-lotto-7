package lotto.view;

import static lotto.model.LotteryRank.FIFTH;
import static lotto.model.LotteryRank.FIRST;
import static lotto.model.LotteryRank.FOURTH;
import static lotto.model.LotteryRank.SECOND;
import static lotto.model.LotteryRank.THIRD;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.model.LotteryRank;
import lotto.model.Lotto;

public class OutputView {

    public void printLotteryCount(int lotteryCount) {
        System.out.println(lotteryCount + "개를 구매했습니다.");
    }

    public void printLotteryNumbers(List<Lotto> purchaseLotteries) {
        purchaseLotteries.forEach(lotto -> {
            Collections.sort(lotto.getNumbers()); // 각 로또 티켓의 번호를 오름차순 정렬
            System.out.println(lotto.getTicketInfo()); // 정렬된 번호 출력
        });
        System.out.println();
    }

    public void printDrawResult(Map<LotteryRank, Integer> drawResult) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + drawResult.get(FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + drawResult.get(FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + drawResult.get(THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + drawResult.get(SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + drawResult.get(FIRST) + "개");
    }

    public void printReturnRate(double returnRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", returnRate) + "%입니다.");
    }

    public void printInvalidInputErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
