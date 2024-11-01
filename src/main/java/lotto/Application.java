package lotto;

import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final ErrorView errorView = new ErrorView();

        LottoApplication lottoApplication = new LottoApplication(inputView, outputView, errorView);

        lottoApplication.run();
    }
}
