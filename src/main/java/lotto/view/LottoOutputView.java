package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class LottoOutputView {

    private LottoOutputView() {
    }

    public static void printPurchaseLotto(List<Lotto> lottos) {
        System.out.format("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(System.out::println);
    }

    public static void printResult(LottoResult lottoResult, int money) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.format("3개 일치 (5,000원) - %d개\n", lottoResult.getFifth());
        System.out.format("4개 일치 (50,000원) - %d개\n", lottoResult.getFourth());
        System.out.format("5개 일치 (1,500,000원) - %d개\n", lottoResult.getThird());
        System.out.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResult.getSecond());
        System.out.format("6개 일치 (2,000,000,000원) - %d개\n", lottoResult.getFirst());
        System.out.format("총 수익률은 %.1f%%입니다.\n", lottoResult.getProfitRate(money));

    }
}
