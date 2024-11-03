package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;

public class LottoOutputView {


    public void printPurchaseLotto(List<Lotto> lottos) {
        System.out.format("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(System.out::println);
    }

    public void printResult(LottoResult lottoResult, int money) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.format("3개 일치 (5,000원) - %d개\n", lottoResult.count(Rank.FIFTH));
        System.out.format("4개 일치 (50,000원) - %d개\n", lottoResult.count(Rank.FOURTH));
        System.out.format("5개 일치 (1,500,000원) - %d개\n", lottoResult.count(Rank.THIRD));
        System.out.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResult.count(Rank.SECOND));
        System.out.format("6개 일치 (2,000,000,000원) - %d개\n", lottoResult.count(Rank.FIRST));
        System.out.format("총 수익률은 %.1f%%입니다.\n", lottoResult.calculateProfitRate(money));
    }
}
