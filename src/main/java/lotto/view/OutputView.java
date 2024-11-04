package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public static void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getSortedNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    public static void printLottoResult(int[] winningCounts, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");

        String[] messages = {
                "3개 일치 (5,000원) - " + winningCounts[4] + "개",
                "4개 일치 (50,000원) - " + winningCounts[3] + "개",
                "5개 일치 (1,500,000원) - " + winningCounts[2] + "개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCounts[1] + "개",
                "6개 일치 (2,000,000,000원) - " + winningCounts[0] + "개"
        };

        for (String message : messages) {
            System.out.println(message);
        }

        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}