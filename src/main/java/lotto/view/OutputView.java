package lotto.view;

import java.util.Map;
import lotto.domain.Rank;

public class OutputView {
    private static final String LOSS_MESSAGE = "손해입니다.";
    private static final String DELIMITER = ", ";
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String DIVIDER = "==========";
    private static final int PROFIT_BASIS = 1;


    private static String getBonus(Rank rank) {
        if (rank.isBonus()) {
            return ", 보너스 볼 일치";
        }
        return " ";
    }

    private static int getCount(Map<Rank, Integer> result, Rank rank) {
        if (result.containsKey(rank)) {
            return result.get(rank);
        }
        return 0;
    }

    private static void printYield(double yield) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은")
                .append(yield)
                .append("입니다.");
        if (yield < PROFIT_BASIS) {
            stringBuilder.append(LOSS_MESSAGE);
        }
        System.out.println(stringBuilder);

    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

}
