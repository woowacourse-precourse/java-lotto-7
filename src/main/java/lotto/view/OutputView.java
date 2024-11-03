package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.PurchasedLottos;

public class OutputView {

    public void showMoneyInputComments() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showLottoWinningNumbersInputComments() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void showLottoBonusNumberInputComments() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showPurchasedLottos(int purchasedCount, PurchasedLottos purchasedLottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", purchasedCount);
        List<Lotto> lottos = purchasedLottos.getLottos();
        lottos.forEach(System.out::println);
    }

    public void showLottoResult(Map<LottoRank, Integer> lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        List<LottoRank> orderedRanks = List.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND,
                LottoRank.FIRST);
        orderedRanks.forEach(rank ->
                System.out.printf("%s (%s원) - %d개\n", rank.getMessage(),
                        String.format("%,d", rank.getPrizeAmount()),
                        lottoResult.getOrDefault(rank, 0))
        );
    }

    public void showLottoRevenue(double revenue) {
        System.out.printf("총 수익률은 %.1f%%입니다.", revenue);
    }

    public void showExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
