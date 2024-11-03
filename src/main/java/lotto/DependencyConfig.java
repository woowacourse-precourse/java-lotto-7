package lotto;

import lotto.controller.LottoController;
import lotto.model.lotto.RandomNumberPicker;
import lotto.model.rank.DefaultRankDeterminer;
import lotto.model.winningNumber.DefaultNumberGenerator;
import lotto.model.winningNumber.NumberGenerator;
import lotto.service.DefaultLottoMachine;
import lotto.service.LottoMachine;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class DependencyConfig {

    public LottoController lottoController() {
        return new LottoController(
                new InputView(), new OutputView(), lottoMachine(), numberGenerator()
        );
    }

    public LottoMachine lottoMachine() {
        return new DefaultLottoMachine(new DefaultRankDeterminer(), new RandomNumberPicker());
    }

    public NumberGenerator numberGenerator() {
        return new DefaultNumberGenerator();
    }
}
