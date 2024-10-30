package lotto;

import lotto.domain.Lotto;

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

    public void printStatistics(Map<WinningStatisticsManager.PrizeTier, Integer> results,double earingRate) {
        System.out.println("\n");
        DecimalFormat formatter = new DecimalFormat("#,###");
        System.out.println("당첨 통계\n---");
        for (WinningStatisticsManager.PrizeTier tier : WinningStatisticsManager.PrizeTier.values()) {
            System.out.printf("%d개 일치 (%s원) - %d개\n",
                tier.getMatchCount(),
                formatter.format(tier.getPrize()),
                results.getOrDefault(tier, 0)
            );
        }
        System.out.println("총 수익률은 "+earingRate+"%입니다.");
    }
}
