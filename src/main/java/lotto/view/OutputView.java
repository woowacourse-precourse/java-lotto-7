package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import lotto.enums.PrintMessage;
import lotto.enums.RankConstants;

public class OutputView {
    public void printLottoList(List<Lotto> lotteries) {
        System.out.println();
        System.out.println(PrintMessage.OUTPUT_LOTTO_LIST.format(lotteries.size()));
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoWinningResult(UserLotto userLotto, float profitRate) {
        System.out.println();
        System.out.println(PrintMessage.OUTPUT_TOTAL_RESULT.getMessage());
        System.out.println(PrintMessage.OUTPUT_FIFTH_PLACE_RESULT.format(userLotto.getWinningCount(RankConstants.FIFTH_PRIZE)));
        System.out.println(PrintMessage.OUTPUT_FOURTH_PLACE_RESULT.format(userLotto.getWinningCount(RankConstants.FOURTH_PRIZE)));
        System.out.println(PrintMessage.OUTPUT_THIRD_PLACE_RESULT.format(userLotto.getWinningCount(RankConstants.THIRD_PRIZE)));
        System.out.println(PrintMessage.OUTPUT_SECOND_PLACE_RESULT.format(userLotto.getWinningCount(RankConstants.SECOND_PRIZE)));
        System.out.println(PrintMessage.OUTPUT_FIRST_PLACE_RESULT.format(userLotto.getWinningCount(RankConstants.FIRST_PRIZE)));

        System.out.println(PrintMessage.OUTPUT_TOTAL_PROFIT_RATE.format(profitRate));
    }
}
