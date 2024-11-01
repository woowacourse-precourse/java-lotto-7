package lotto;

import lotto.view.ErrorView;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final ErrorView errorView = new ErrorView();

        LottoApplication lottoApplication = new LottoApplication(inputView, errorView);

        lottoApplication.run();
    }
}
