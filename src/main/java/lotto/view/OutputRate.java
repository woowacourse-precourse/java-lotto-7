package lotto.view;

public class OutputRate {

    private static final String MESSAGE_RATE = "총 수익률은 %.1f%%입니다.";

    public static void rateOutput(double rate) {
        System.out.println(String.format(MESSAGE_RATE, rate));
    }

}
