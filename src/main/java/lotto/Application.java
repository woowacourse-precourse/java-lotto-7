package lotto;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        LottoMatcher lottoMatcher = new LottoMatcher();
        Input inputHandler = new InputHandler();
        LottoPurchase lottoPurchase = new LottoPurchase(lottoGenerator);
        ResultCalculator resultCalculator = new ResultCalculator(lottoMatcher);
        Output outputHandler = new OutputHandler();

        LottoController lottoController = new LottoController(inputHandler, lottoPurchase, resultCalculator, outputHandler);

        lottoController.play();
    }
}
