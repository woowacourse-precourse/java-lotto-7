package lotto.ui;

import lotto.Lotto;
import lotto.service.WinningStatisticsManager;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputManager {
    public void requestMoney(){
        System.out.println("구입 금액을 입력해주세요.");
    }

    public void requestWinningNumber(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printPurchasedLotto(List<Lotto> lottoList){
        System.out.println("\n");
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        lottoList.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
        System.out.println("\n");
    }

    public void printStatistics(Map<WinningStatisticsManager.PrizeTier, Integer> results, BigDecimal earningRate) {
        System.out.println("\n");
        DecimalFormat formatter = new DecimalFormat("#,###");
        DecimalFormat rateFormatter = new DecimalFormat("#.#");
        System.out.println("당첨 통계\n---");
        for (WinningStatisticsManager.PrizeTier tier : WinningStatisticsManager.PrizeTier.values()) {
            System.out.print(tier.getMatchCount() + "개 일치");
            if (tier.getMatchCount() == 5 && tier.getBonusCount() == 1) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.printf(" (%s원) - %d개\n",
                    formatter.format(tier.getPrize()),
                    results.getOrDefault(tier, 0)
            );
        }
        String result = String.format("%.1f",earningRate);
        System.out.println("총 수익률은 " + result + "%입니다.");
    }

}
