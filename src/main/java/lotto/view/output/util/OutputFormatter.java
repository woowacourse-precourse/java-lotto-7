package lotto.view.output.util;

public final class OutputFormatter {
    private static final String PURCHASE_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.\n";

    public static String formatPurchaseLottoCount(Integer count) {
        return String.format(PURCHASE_LOTTO_COUNT_FORMAT, count);
    }
}
