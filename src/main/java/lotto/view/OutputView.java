package lotto.view;

import java.util.List;

import static lotto.constant.ViewConstants.BOUGHT_LOTTO_MESSAGE;
import static lotto.constant.ViewConstants.WIN_RATE_MESSAGE;
import static lotto.constant.ViewConstants.SEPARATE_LINE;
import static lotto.constant.ViewConstants.FIFTH_HIT_MESSAGE;
import static lotto.constant.ViewConstants.FOURTH_HIT_MESSAGE;
import static lotto.constant.ViewConstants.THIRD_HIT_MESSAGE;
import static lotto.constant.ViewConstants.SECOND_HIT_MESSAGE;
import static lotto.constant.ViewConstants.FIRST_HIT_MESSAGE;
import static lotto.constant.ViewConstants.PROFIT_RATE_MESSAGE;
import static lotto.constant.ViewConstants.END_LINE;
import static lotto.constant.UtilConstants.ZERO;
import static lotto.constant.UtilConstants.ONE;
import static lotto.constant.UtilConstants.TWO;
import static lotto.constant.UtilConstants.THREE;
import static lotto.constant.UtilConstants.FOUR;

public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.println();
        System.out.println(count + BOUGHT_LOTTO_MESSAGE.getMessage());
    }

    public static void printLottoNumbers(List<String> lottos) {
        for (String lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printStatisticOutput() {
        System.out.println();
        System.out.println(WIN_RATE_MESSAGE.getMessage());
        System.out.println(SEPARATE_LINE.getMessage());
    }

    public static void printStatisticResult(List<Integer> placeCount, float profitRate) {
        System.out.println(String.format(FIFTH_HIT_MESSAGE.getMessage(), placeCount.get(FOUR)));
        System.out.println(String.format(FOURTH_HIT_MESSAGE.getMessage(), placeCount.get(THREE)));
        System.out.println(String.format(THIRD_HIT_MESSAGE.getMessage(), placeCount.get(TWO)));
        System.out.println(String.format(SECOND_HIT_MESSAGE.getMessage(), placeCount.get(ONE)));
        System.out.println(String.format(FIRST_HIT_MESSAGE.getMessage(), placeCount.get(ZERO)));
        System.out.println(String.format(PROFIT_RATE_MESSAGE.getMessage(), profitRate));
    }

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
