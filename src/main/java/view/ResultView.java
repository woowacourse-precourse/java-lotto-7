package view;

public class ResultView {

    private static final String PURCHASE_COMPLETE_PROMPT = "개를 구매했습니다.";

    public static void showLottoPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COMPLETE_PROMPT);
    }
}
