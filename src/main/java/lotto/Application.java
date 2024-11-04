package lotto;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.generateLotto(inputView.getLottoCount());
        inputView.inputStart(outputView);
        Lotto lotto = new Lotto(inputView.getLottoNumbers());
        lotto.start(outputView,inputView);
    }
}