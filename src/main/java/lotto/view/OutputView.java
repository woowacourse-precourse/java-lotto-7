package lotto.view;

public class OutputView {
    private static final String PURCHASE_AMOUNT_INPUT = "구입 금액을 입력해 주세요.";
    private static final String PURCHASE_Lotto_Count = "개를 구매했습니다.";

    public static void printPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
    }
    public static void printPurchaseLottoCount(int Count) {
        System.out.println(System.lineSeparator()+Count+PURCHASE_Lotto_Count);
    }
}
