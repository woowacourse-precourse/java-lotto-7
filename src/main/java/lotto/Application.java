package lotto;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new InputView(), new OutputView(),
                new LottoGenerator());
        lottoGameController.run();
    }
}
