package lotto.view;

import lotto.domain.AutoLotto;
import lotto.domain.rule.WinningRules;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void lottoCount(long lottoCount) {
        System.out.println();
        System.out.println(lottoCount+"개를 구매했습니다.");
    }

    public void lottos(List<AutoLotto> autoLottoList) {
        autoLottoList.stream()
                .map(AutoLotto::getNumbers)
                .forEach(System.out::println);
    }

    public void error(String error) {
        System.out.println(error + " 다시 입력하세요.");
    }

    public void winningResult(Map<WinningRules, Long> results) {
        DecimalFormat currencyFormat = new DecimalFormat("#,###");
        winningStatisticsStart();
        for (WinningRules rank : WinningRules.values()) {
            if (rank != WinningRules.NO_MATCH) {
                System.out.printf("%d개 일치%s (%s원) - %d개\n",
                        rank.getMatchCount(),
                        rank == WinningRules.FIVE_MATCH_WITH_BONUS ? ", 보너스 볼 일치" : "",
                        currencyFormat.format(rank.getPrize()),
                        results.getOrDefault(rank,0L));
            }
        }
    }

    public void winningStatisticst(float winningStatistics) {
        System.out.printf("총 수익률은 %.1f%%입니다.", winningStatistics);
    }

    private void winningStatisticsStart() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }


}
