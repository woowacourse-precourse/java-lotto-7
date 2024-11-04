package lotto.view;

import java.util.List;
import lotto.constant.LottoRank;
import lotto.dto.LottoResultResponse;
import lotto.dto.PurchaseResultResponse;

public class OutputView {
    public OutputView() {
    }

    public void printPurchase(PurchaseResultResponse response) {
        System.out.println(response.purchaseCount() + "개를 구매했습니다.");
        for (List<Integer> lotto : response.numbers()) {
            printLotto(lotto);
        }
        System.out.println();
    }

    public void printLotto(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i));
            if (i < lotto.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void printLottoResult(LottoResultResponse response) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NO_WINNER) {
                continue;
            }
            int winCount = response.lottoResult().getOrDefault(rank, 0);
            printWinningResult(rank, winCount);
        }
        System.out.println("총 수익률은 " + response.earningRate() + "%입니다.");
    }

    public void printWinningResult(LottoRank lottoRank, int winCount) {
        int matchCount = lottoRank.getMatchCount();
        int prizeMoney = lottoRank.getPrizeMoney();
        boolean bonusNumberMatch = lottoRank.getBonusNumberMatch();

        if (bonusNumberMatch) {
            System.out.println(
                    matchCount + "개 일치, 보너스 볼 일치 (" + String.format("%,d", prizeMoney) + "원) - " + winCount + "개");
        } else {
            System.out.println(matchCount + "개 일치 (" + String.format("%,d", prizeMoney) + "원) - " + winCount + "개");
        }
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

}
