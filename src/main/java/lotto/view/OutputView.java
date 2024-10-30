package lotto.view;

public class OutputView {
    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printPurchaseAmount(int purchaseAmount) {
        System.out.println();
        System.out.println(purchaseAmount+ "개를 구매했습니다.");
    }
}
