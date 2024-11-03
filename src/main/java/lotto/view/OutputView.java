package lotto.view;

import java.util.Map;
import lotto.dto.LottoResponseDTO;
import lotto.dto.PurchaseResultDTO;
import lotto.model.LottoRank;

public class OutputView {

    public void showErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void showPurchasedLottos(PurchaseResultDTO result) {
        System.out.printf("%d개를 구매했습니다.\n", result.getCount());
        for (LottoResponseDTO lotto : result.getResults()) {
            System.out.println(lotto);
        }
    }

    public void showLottoResults(Map<LottoRank, Integer> results) {
        System.out.println("당첨 통계\n---\n");
        showFifthResult(results);
        showFourthResult(results);
        showThirdResult(results);
        showSecondResult(results);
        showFirstResult(results);
        showEarningRate(results);

    }

    private void showFirstResult(Map<LottoRank, Integer> results) {
        System.out.printf("%d개 일치 (%,d원) - %d개\n", LottoRank.FIRST.getWinningCount(), LottoRank.FIRST.getPrize(),
                results.get(LottoRank.FIRST));
    }

    private void showSecondResult(Map<LottoRank, Integer> results) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", LottoRank.SECOND.getWinningCount(),
                LottoRank.SECOND.getPrize(), results.get(LottoRank.SECOND));
    }

    private void showThirdResult(Map<LottoRank, Integer> results) {
        System.out.printf("%d개 일치 (%,d원) - %d개\n", LottoRank.THIRD.getWinningCount(), LottoRank.THIRD.getPrize(),
                results.get(LottoRank.THIRD));
    }

    private void showFourthResult(Map<LottoRank, Integer> results) {
        System.out.printf("%d개 일치 (%,d원) - %d개\n", LottoRank.FOURTH.getWinningCount(),
                LottoRank.FOURTH.getPrize(), results.get(LottoRank.FOURTH));
    }

    private void showFifthResult(Map<LottoRank, Integer> results) {
        System.out.printf("%d개 일치 (%,d원) - %d개\n", LottoRank.FIFTH.getWinningCount(), LottoRank.FIFTH.getPrize(),
                results.get(LottoRank.FIFTH));
    }

    private void showEarningRate(Map<LottoRank, Integer> results) {
        long totalEarning = 0;
        int lottoCount = 0;
        for (LottoRank lottoRank : results.keySet()) {
            totalEarning += (long) results.get(lottoRank) * lottoRank.getPrize();
            lottoCount += results.get(lottoRank);
        }
        System.out.printf("총 수익률은 %.2f%%입니다.\n", (double) totalEarning / lottoCount);
    }
}
