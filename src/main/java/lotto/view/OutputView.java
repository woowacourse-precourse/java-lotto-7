package lotto.view;

import static lotto.model.constant.LottoRank.FIFTH;
import static lotto.model.constant.LottoRank.FIRST;
import static lotto.model.constant.LottoRank.FOURTH;
import static lotto.model.constant.LottoRank.SECOND;
import static lotto.model.constant.LottoRank.THIRD;
import static lotto.model.constant.LottoRule.PRICE;

import java.util.Map;
import lotto.dto.LottoResponseDTO;
import lotto.dto.PurchaseResultDTO;
import lotto.model.constant.LottoRank;

public class OutputView {

    public void showErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void showPurchasedLottos(PurchaseResultDTO result) {
        System.out.printf("\n%d개를 구매했습니다.\n", result.getCount());
        for (LottoResponseDTO lotto : result.getResults()) {
            System.out.println(lotto);
        }
    }

    public void showLottoResults(Map<LottoRank, Integer> results) {
        System.out.println("\n당첨 통계\n---");
        showFifthResult(results);
        showFourthResult(results);
        showThirdResult(results);
        showSecondResult(results);
        showFirstResult(results);
        showEarningRate(results);

    }

    private void showFirstResult(Map<LottoRank, Integer> results) {
        System.out.printf("%d개 일치 (%,d원) - %d개\n", FIRST.getWinningCount(), FIRST.getPrize(),
                results.get(FIRST));
    }

    private void showSecondResult(Map<LottoRank, Integer> results) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", SECOND.getWinningCount(),
                SECOND.getPrize(), results.get(SECOND));
    }

    private void showThirdResult(Map<LottoRank, Integer> results) {
        System.out.printf("%d개 일치 (%,d원) - %d개\n", THIRD.getWinningCount(), THIRD.getPrize(),
                results.get(THIRD));
    }

    private void showFourthResult(Map<LottoRank, Integer> results) {
        System.out.printf("%d개 일치 (%,d원) - %d개\n", FOURTH.getWinningCount(),
                FOURTH.getPrize(), results.get(FOURTH));
    }

    private void showFifthResult(Map<LottoRank, Integer> results) {
        System.out.printf("%d개 일치 (%,d원) - %d개\n", FIFTH.getWinningCount(), FIFTH.getPrize(),
                results.get(FIFTH));
    }

    private void showEarningRate(Map<LottoRank, Integer> results) {
        long totalEarning = 0;
        int lottoCount = 0;
        for (LottoRank lottoRank : results.keySet()) {
            totalEarning += (long) results.get(lottoRank) * lottoRank.getPrize();
            lottoCount += results.get(lottoRank);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (double) totalEarning / (lottoCount * PRICE.getConstant()) * 100);
    }
}
