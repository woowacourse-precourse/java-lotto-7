package lotto;

import lotto.controller.LottoController;
import lotto.model.lotto.RandomNumberPicker;
import lotto.model.rank.DefaultRankDeterminer;
import lotto.model.winningNumber.DefaultNumberGenerator;
import lotto.service.DefaultLottoMachine;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new InputView(), new OutputView(),
                new DefaultLottoMachine(new DefaultRankDeterminer(), new RandomNumberPicker()),
                new DefaultNumberGenerator()
        );
        lottoController.run();
    }
}
