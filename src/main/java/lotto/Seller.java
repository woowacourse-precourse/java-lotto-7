package lotto;

public class Seller {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요";
    private static final String HOW_MANY_LOTTO_TEMPLATE = "%d개를 구매했습니다.";

    public static void setInputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static int countNumberOfLotto(int purchaseAmount) {
        int countNumberOfLotto = purchaseAmount / 1000;
        return countNumberOfLotto;
    }

    public static String getHowManyLottoMessage(int numberOfLotto) {
        return String.format(HOW_MANY_LOTTO_TEMPLATE, numberOfLotto);
    }
}
