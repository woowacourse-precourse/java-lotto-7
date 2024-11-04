package lotto.view;

import java.text.DecimalFormat;
import lotto.view.constant.OutputFormat;

public class Output {

    public static void purchaseAmount(Integer amount) {
        String output = String.format(OutputFormat.PURCHASE_AMOUNT.getForm(), amount);
        System.out.println(output);
    }

    public static void prizeStatistic() {
        System.out.println(OutputFormat.PRIZE_STATISTICS_MESSAGE.getForm());
    }

    public static void winner(Long correct, Long prize, Long count ) {
        String output = java.lang.String.format(OutputFormat.PRIZE_STATUS_FORM.getForm(), correct, money(prize), count);
        System.out.println(output);
    }

    public static void secondWinner(Long correct, Long prize, Long count) {
        String output = java.lang.String.format(OutputFormat.PRIZE_STATUS_FORM_SECOND.getForm(), correct, money(prize),count);
        System.out.println(output);
    }

    private static String money(Long prize) {
        return new DecimalFormat(OutputFormat.MONEY_FORMAT.getForm()).format(prize);
    }
}