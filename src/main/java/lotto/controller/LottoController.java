package lotto.controller;

import lotto.enums.InputMessage;
import lotto.exception.handler.MoneyErrorHandler;
import lotto.exception.handler.ParseErrorHandler;
import lotto.model.vo.Money;
import lotto.service.LottoService;
import lotto.util.StringParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void buy() {
        Money money = inputMoney();
        OutputView.printLottoPurchaseResult(lottoService.buyLotto(money));
    }


    private static Money inputMoney() {
        try {
            String moneyInfo = InputView.getInput(InputMessage.INPUT_MONEY);
            return new Money(StringParser.toNumber(moneyInfo));
        } catch (ParseErrorHandler | MoneyErrorHandler e) {
            OutputView.printError(e);
            return inputMoney();
        }
    }


}
