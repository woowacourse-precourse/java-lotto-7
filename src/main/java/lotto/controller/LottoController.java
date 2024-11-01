package lotto.controller;

import lotto.dto.LottoNumbers;
import lotto.model.Money;
import lotto.model.lotto.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void play() {
        buyLotto();
    }

    private void buyLotto() {
        while (true) {
            try {
                final Money money = new Money(inputView.inputMoney());
                final Lottos lottos = lottoService.generate(money);
                printBuyingLottos(money, lottos);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }

    }

    private void printBuyingLottos(final Money money, final Lottos lottos) {
        outputView.printLottoCount(money.calculateLottoCount());
        LottoNumbers lottoNumbers = new LottoNumbers(lottos);
        outputView.printLottoNumbers(lottoNumbers);
    }
}
