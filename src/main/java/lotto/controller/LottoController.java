package lotto.controller;

import static lotto.config.GameMessage.GAME_START_MESSAGE;
import static lotto.config.GameMessage.REQUEST_BONUS_NUMBER_MESSAGE;
import static lotto.config.GameMessage.REQUEST_WINNING_NUMBER_MESSAGE;
import static lotto.domain.factory.LottoFactory.generateLotto;
import static lotto.domain.factory.ResultFactory.generateResult;
import static lotto.handler.Handler.repeatInputUntilValid;
import static lotto.util.ProfitCalculator.calculateProfit;
import static lotto.view.InputView.getUserInput;
import static lotto.view.InputView.getUserInputByList;
import static lotto.view.OutputView.printMessage;
import static lotto.view.OutputView.printPurchaseLottoMessage;
import static lotto.view.OutputView.printResultMessage;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Purchase;
import lotto.domain.Result;

public class LottoController {
    private LottoMachine lottoMachine;

    public LottoController() {
        lottoMachine = new LottoMachine();
    }

    public void start() {
        printMessage(GAME_START_MESSAGE);
        Purchase purchase = repeatInputUntilValid(() -> new Purchase(getUserInput()));

        List<Lotto> lottos = generateLotto(purchase);
        printPurchaseLottoMessage(lottos);

        printMessage(REQUEST_WINNING_NUMBER_MESSAGE);
        repeatInputUntilValid(() -> lottoMachine.assignWinningNumbers(getUserInputByList()));
        printMessage(REQUEST_BONUS_NUMBER_MESSAGE);
        repeatInputUntilValid(() -> lottoMachine.assignBonusNumber(getUserInput()));

        Result lottoResult = generateResult(lottoMachine, lottos);
        double profit = calculateProfit(lottoResult.getTotalPrize(), purchase);
        printResultMessage(lottoResult, profit);
    }
}
