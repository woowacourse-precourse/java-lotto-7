package lotto.controller;

import static lotto.view.output.LottoOutputView.*;
import static lotto.view.output.PrizeOutputView.*;
import static lotto.view.output.ProfitOutputView.*;
import static lotto.view.output.TicketOutputView.*;

import java.util.List;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.ProfitCalculator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.input.InputBonusNumberView;
import lotto.view.input.InputMoneyView;
import lotto.view.input.InputWinningNumberView;

public class LottoController {
    public void start() {
        Money money = getMoney();
        showTicket(money.getTicket());

        List<Lotto> lottos = getLottos(money);
        showLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();

        PrizeResult prizeResult = getPrizeResult(lottos, winningLotto);
        showPrizeResults(prizeResult);

        double profitRatio = getProfitRate(money, prizeResult);
        showProfitRate(profitRatio);
    }

    private Money getMoney() {
        InputMoneyView inputMoneyView = new InputMoneyView();
        try {
            int moneyInput = inputMoneyView.getValue();
            return new Money(moneyInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }

    private List<Lotto> getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();

        try {
            return lottoGenerator.generateLottoGroup(money.getTicket());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottos(money);
        }
    }

    private WinningLotto getWinningLotto() {
        InputWinningNumberView inputWinningNumberView = new InputWinningNumberView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();
        try {
            List<Integer> winningNumbers = inputWinningNumberView.getValue();
            int bonusNumber = inputBonusNumberView.getValue();

            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    private PrizeResult getPrizeResult(List<Lotto> lottos, WinningLotto winningLotto) {
        return new PrizeResult(lottos, winningLotto);
    }

    private double getProfitRate(Money money, PrizeResult prizeResult) {
        ProfitCalculator profitCalculator = new ProfitCalculator(money, prizeResult);
        return profitCalculator.calculateProfitRatio();
    }
}
