package lotto.View;

public class OutputView {
    private static final String PRINT_PURCHASE_COUNT="개를 구매했습니다.";
    private static final String PRINT_WINNING_STATISTICS="당첨 통계";
    private static final String PRINT_SEPARATE_SENTENCE="---";

    public static void print_purchase_count(int purchase_count) {
        System.out.println(purchase_count+PRINT_PURCHASE_COUNT);
    }

}
