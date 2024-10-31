package lotto.controller;

import lotto.domain.entity.Lottos;
import lotto.domain.entity.RandomLottoNumberGenerator;
import lotto.domain.service.LottoStore;
import lotto.ui.ConsoleInputView;
import lotto.ui.ConsoleOutputView;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.ui.parser.InputParser;

public class LottoController {

    private final LottoStore lottoStore;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoStore = new LottoStore(new RandomLottoNumberGenerator());
        this.inputView = new ConsoleInputView(new InputParser());
        this.outputView = new ConsoleOutputView();
    }

    public void run() {
        final int pay = inputView.inputPayment();

        final Lottos lottos = lottoStore.issueLottos(pay);

        outputView.printLottos(lottos);
    }
}
