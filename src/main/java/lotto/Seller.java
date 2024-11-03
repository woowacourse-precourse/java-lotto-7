package lotto;

public class Seller {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요";

    public static void setInputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static int countNumberOfLotto(int purchaseAmount) {
        int countNumberOfLotto = purchaseAmount / 1000;
        return countNumberOfLotto;
    }
}
