package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.generateLotto(inputView.getLottoCount());
        inputView.inputStart(outputView);
    }
}