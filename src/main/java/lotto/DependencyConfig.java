package lotto;

import lotto.controller.LottoController;
import lotto.model.lotto.lottoNumber.RandomNumberPicker;
import lotto.model.lotto.winningResult.rank.DefaultRankDeterminer;
import lotto.service.winningNumber.DefaultNumberGenerator;
import lotto.service.winningNumber.NumberGenerator;
import lotto.service.lotto.DefaultLottoMachine;
import lotto.service.lotto.LottoMachine;
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
