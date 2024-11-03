package lotto.view;

import static lotto.exception.Validator.LOTTERY_PRICE;

import java.util.Map;
import lotto.service.CommonWinningStrategy;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printWinningStatistics(CommonWinningStrategy commonWinningStrategy, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(commonWinningStrategy.getMatch()).append("개 일치");
        if (commonWinningStrategy.getBonusMatch()) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(formatLongNumber(commonWinningStrategy.getMoney())).append("-").append(count).append("개");

        System.out.println(sb);
    }

    public void printRateOfReturn(Map<CommonWinningStrategy, Integer> winningCounts, long numberOfLottery) {
        long entireWinningMoney = 0;

        for (Map.Entry<CommonWinningStrategy, Integer> entry : winningCounts.entrySet()) {
            entireWinningMoney += (entry.getValue() * entry.getKey().getMoney());
        }

        System.out.println((entireWinningMoney / (numberOfLottery * LOTTERY_PRICE)) * 100);
        double rateOfReturn = roundToTwoDecimalPlaces((entireWinningMoney / (numberOfLottery * LOTTERY_PRICE)) * 100);

        System.out.println("총 수익률은 " + formatDoubleNumber(rateOfReturn) + "%입니다.");
    }

    private String formatLongNumber(long number) {
        return String.format(" (%,d원) ", number);
    }

    private String formatDoubleNumber(double number) {
        return String.format("%,.1f", number);
    }

    private double roundToTwoDecimalPlaces(long number) {
        double changedNumber = (double) number;
        return Math.round(changedNumber * 10) / 10.0;
    }
}
