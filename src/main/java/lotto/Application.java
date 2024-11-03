package lotto;

import lotto.controller.LottoController;
import lotto.model.rank.RankDeterminer;
import lotto.service.LottoMachineImpl;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new InputView(), new OutputView(), new LottoMachineImpl(new RankDeterminer())
        );
        lottoController.run();
    }
}
