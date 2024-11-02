package lotto;

import lotto.controller.LottoController;
import lotto.service.DefaultLottoResultCalculator;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.RandomUniqueLottoNumGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputService(new InputView()), new OutputView(),
                new LottoService(new DefaultLottoResultCalculator(), new RandomUniqueLottoNumGenerator()));
        lottoController.start();
    }
}
