package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public final class OutputView {

    public static void printLotto(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.print("[");
            String result = lotto.getSortedNumbers().stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.print(result);
            System.out.println("]");
        }
        System.out.println();
    }

    public static void printResult(Map<LottoResult, Integer> result, int money) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        List<LottoResult> list = Arrays.stream(LottoResult.values())
                .filter(lottoResult -> !lottoResult.equals(LottoResult.NONE))
                .toList();
        double sum = 0;
        for (LottoResult lottoResult : list) {
            int matchedCount = lottoResult.getMatchedCount();
            int rewardAmount = lottoResult.getRewardAmount();
            int winningCount = result.getOrDefault(lottoResult, 0);
            sum += winningCount * rewardAmount;
            System.out.print(matchedCount + "개 일치");
            if (lottoResult.isBonusMatched()) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.printf(" (%,d원) - %d개", rewardAmount, winningCount);
            System.out.println();
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", (double) sum * 100 / money);
    }
}
