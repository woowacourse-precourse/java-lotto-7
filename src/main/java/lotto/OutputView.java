package lotto;

public class OutputView {
    private static final String PURCHASE_AMOUNT_IS = "개를 구매했습니다.";
    private static final String EARNING_RATE = "총 수익률은 %.1f%%입니다."; // 소수 첫째 자리까지 표시

    private OutputView() {
        throw new UnsupportedOperationException();
    }

    public static void printPurchaseAmount(int quantity) {
        System.out.println(quantity + PURCHASE_AMOUNT_IS);
    }

    public static void printPurchasedLottos(String lottoGroup) {
        System.out.println(lottoGroup);
    }

    public static void printEarningRate(float earningRate) {
        System.out.printf((EARNING_RATE) + "%n", earningRate);
    }

    public static void printResult(String summary) {
        System.out.println(summary);
    }
}
