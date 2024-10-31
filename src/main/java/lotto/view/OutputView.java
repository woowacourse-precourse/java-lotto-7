package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import lotto.enums.PrintMessage;

public class OutputView {
    public void printLottoList(List<Lotto> lotteries){
        System.out.println();
        System.out.println(PrintMessage.OUTPUT_LOTTO_LIST.format(lotteries.size()));
        for(Lotto lotto : lotteries){
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoWinningResult(UserLotto userLotto, float profitRate){
        System.out.println();
        System.out.println(PrintMessage.OUTPUT_TOTAL_RESULT.getMessage());
        System.out.println(PrintMessage.OUTPUT_FIFTH_PLACE_RESULT.format(userLotto.getWinningCount(5)));
        System.out.println(PrintMessage.OUTPUT_FOURTH_PLACE_RESULT.format(userLotto.getWinningCount(4)));
        System.out.println(PrintMessage.OUTPUT_THIRD_PLACE_RESULT.format(userLotto.getWinningCount(3)));
        System.out.println(PrintMessage.OUTPUT_SECOND_PLACE_RESULT.format(userLotto.getWinningCount(2)));
        System.out.println(PrintMessage.OUTPUT_FIRST_PLACE_RESULT.format(userLotto.getWinningCount(1)));

        System.out.println(PrintMessage.OUTPUT_TOTAL_PROFIT_RATE.format(profitRate));
    }
}
