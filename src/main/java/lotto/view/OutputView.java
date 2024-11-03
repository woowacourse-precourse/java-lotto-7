package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.RankResult;
import lotto.domain.RankType;
import lotto.util.message.PromptMessage;

public class OutputView {

    private static OutputView outputView;

    private OutputView(){
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void displayLottoList(int purchaseAmount, List<Lotto> lottoList) {
        System.out.println();
        System.out.println(purchaseAmount + PromptMessage.LOTTO_AMOUNT_MESSAGE);
        lottoList.forEach(Lotto::displayNumbers);
        System.out.println();
    }

    public void displayWinningStatistics(Map<RankType, RankResult> statistics, String earningRate) {
        System.out.println();
        System.out.println(PromptMessage.WINNING_STATISTICS_MESSAGE);
        statistics.forEach((rankType, rankResult) ->
            System.out.println(rankType.getDescription() + " - " + rankResult.getCount())
        );
        System.out.print("총 수익률은 " + earningRate + "%입니다.");
    }

    public void close() {
        if (outputView != null) {
            outputView = null;
        }
    }
}
