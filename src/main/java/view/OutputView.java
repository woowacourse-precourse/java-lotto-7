package view;

import domain.Ranking;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {
    public static void outBuyingPriceView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void outBuyingQuantityView(int buyingQuantity) {
        System.out.println();
        System.out.println(buyingQuantity + "개를 구매했습니다.");
    }

    public static void outGenerateNumbersView(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void outLottoNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void outBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void outTotal(Map<Ranking, Integer> total, double buyingPrice) {
        System.out.println("당첨 통계");
        System.out.println("---");
        double sum = 0;
        for (Entry<Ranking, Integer> ranking : total.entrySet()) {
            Ranking rank = ranking.getKey();
            Integer count = ranking.getValue();
            sum += rank.getWinningMoney() * count;
            if (rank != Ranking.ZERO) {
                System.out.println(rank.getMessage() + count + "개");
            }
        }
        rateOfReturn(buyingPrice, (double) sum);
    }

    private static void rateOfReturn(double buyingPrice, double sum) {
        double grow = sum / buyingPrice;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", grow * 100.0);
    }
}
