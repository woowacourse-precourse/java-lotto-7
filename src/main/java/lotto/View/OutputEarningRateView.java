package lotto.View;

import lotto.Enum.PrintConstants;

import java.text.DecimalFormat;

public class OutputEarningRateView {
    public void printEarningRate(double earningRate) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.#");
        System.out.println(String.format(PrintConstants.OUTPUT_ERNING_RATE.getMessage(), decimalFormat.format(Math.round(earningRate*10)/10.0)));
    }
}
