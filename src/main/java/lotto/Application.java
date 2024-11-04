package lotto;

import lotto.controller.LottoController;
import lotto.util.GenerateNumbers;
import lotto.util.GenerateRandomNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GenerateNumbers generateRandomNumbers = new GenerateRandomNumbers();

        LottoController lottoController = new LottoController(inputView, outputView, generateRandomNumbers);
        lottoController.start();
    }
}
