package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.constant.SystemMessage;

public class OutputView {
    public void printGeneratedLottos(int number, List<Lotto> lottolist) {
        System.out.printf(SystemMessage.DISPLAY_PURCHASED_LOTTO_COUNT.getMessage(), number);
        System.out.println();
        for (Lotto lotto : lottolist) {
            System.out.println(lotto.printLottos());
        }
        System.out.println();
    }

    public void printResult(int[] result, double profitRate) {
        System.out.println(SystemMessage.RESULT_HEADER.getMessage());
        System.out.printf(SystemMessage.MATCH_THREE.getMessage() + "\n", result[4]);
        System.out.printf(SystemMessage.MATCH_FOUR.getMessage() + "\n", result[3]);
        System.out.printf(SystemMessage.MATCH_FIVE.getMessage() + "\n", result[2]);
        System.out.printf(SystemMessage.MATCH_FIVE_BONUS.getMessage() + "\n", result[1]);
        System.out.printf(SystemMessage.MATCH_SIX.getMessage() + "\n", result[0]);
        System.out.printf(SystemMessage.PROFIT_RATE.getMessage(), profitRate);

    }
}
