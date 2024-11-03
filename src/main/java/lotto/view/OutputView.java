package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printUserLottoNumber(List<Lotto> lottoList){

        System.out.println(lottoList.size()+"개를 구매했습니다.");

        lottoList.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .forEach(System.out::println);

        System.out.println();
    }

    public static void printLottoResult(Map<WinningResult, Integer> winningResultCount, double profitRate){


        System.out.println("당첨 통계");
        System.out.println("---");

        for (WinningResult result : WinningResult.values()) {
            if (result == WinningResult.FIVE_MATCH_BONUS) {
                printBonusMatchResult(result, winningResultCount);
                continue;
            }
            printRegularMatchResult(result, winningResultCount);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static void printBonusMatchResult(WinningResult result, Map<WinningResult, Integer> winningResultCount) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                result.getMatchCount(),
                String.format("%,d", result.getPrize()),
                winningResultCount.getOrDefault(result, 0)
        );
    }

    private static void printRegularMatchResult(WinningResult result, Map<WinningResult, Integer> winningResultCount) {
        System.out.printf("%d개 일치 (%s원) - %d개%n",
                result.getMatchCount(),
                String.format("%,d", result.getPrize()),
                winningResultCount.getOrDefault(result, 0)
        );
    }
}
