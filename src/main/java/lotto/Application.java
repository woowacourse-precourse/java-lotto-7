package lotto;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView(inputValidator);
        OutputView outputView = new OutputView();

        LottoMachine lottoMachine = new LottoMachine(inputView, outputView);
        lottoMachine.start();
    }
}
