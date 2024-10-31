package lotto;

import constants.Constants;

import java.util.List;

public class LottoOutput {
    public void printLottos(List<Lotto> lottos, int count) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    String[] prizeMessages = {
            "6개 일치 (%s원) - %d개",
            "5개 일치, 보너스 볼 일치 (%s원) - %d개",
            "5개 일치 (%s원) - %d개",
            "4개 일치 (%s원) - %d개",
            "3개 일치 (%s원) - %d개",
    };

    public void printResult(LottoResult prizeCountMap, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = Constants.REWARD_TYPE_COUNT; i > 0; i--) {
            String formatMoney = String.format("%,d", Constants.REWARD_PRICE[i-1]);
            String formattedMessage = String.format(prizeMessages[i-1], formatMoney, prizeCountMap.getPrizeCount(i));
            System.out.println(formattedMessage);
        }
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}
