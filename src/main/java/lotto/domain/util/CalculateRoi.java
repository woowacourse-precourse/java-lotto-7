package lotto.domain.util;

public class CalculateRoi {

    private CalculateRoi() {}

    // 수익률 공식 = (수익금 / 투자금) * 100
    public static String calculate(long winningAmount, int amount) {
        double result = (double) winningAmount / amount * 100;
        return String.format("%.1f", result);
    }
}
