package lotto.view;

import lotto.data.Lotto;
import lotto.data.Result;

import java.util.List;

public class OutputView {
    public void printPurchaseLotto(List<Lotto> purchaseLottoList) {
        System.out.println();
        System.out.println(purchaseLottoList.size() + "개를 구매했습니다.");
        purchaseLottoList.stream().forEach(System.out::println);
    }

    public void printResult(Result result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getThreeNumberMatch() + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getFourNumberMatch() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getFiveNumberMatch() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getBonusNumberMatch() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getSixNumberMatch() + "개");
    }

    public void printProfitRate(Result result, Long purchaseMoney) {
        double profitRate =
                (result.getThreeNumberMatch() * 5000L
                        + result.getFourNumberMatch() * 50000L
                        + result.getFiveNumberMatch() * 1500000L
                        + result.getBonusNumberMatch() * 30000000L
                        + result.getSixNumberMatch() * 2000000000L) / (double) purchaseMoney;
        System.out.println("총 수익률은 " + profitRate * 100 + "%입니다.");
    }
}
