package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ErrorView errorView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView,
                           ErrorView errorView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorView = errorView;
        this.lottoService = lottoService;
    }

    public void startLottoDraw() {
        Money money = getMoney();
        Lottos lottos = lottoService.generateLottos(money.getMoney());

        outputView.printLottos(lottos);
    }

    private Money getMoney() {
        Money money = null;

        while (money == null) {
            try {
                String moneyInput = inputView.requestMoneyInput();
                int parsedMoney = Integer.parseInt(moneyInput);
                money = new Money(parsedMoney);
            } catch (NumberFormatException e) {
                errorView.printMoneyParsingError();
            } catch (IllegalArgumentException e) {
                errorView.printErrorMessage(e.getMessage());
            }
        }

        return money;
    }
}
