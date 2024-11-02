package lotto;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();

        int lottoCount = lottoPurchase.inputPurchaseAmount();
        System.out.println("구입한 로또 수: " + lottoCount);
    }
}
