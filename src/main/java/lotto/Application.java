package lotto;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoPurchase lottoPurchase = new LottoPurchase();

        LottoGame lottoGame = new LottoGame(inputView, outputView, lottoPurchase);
        lottoGame.start();
    }
}
