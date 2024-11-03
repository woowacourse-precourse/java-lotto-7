package lotto.controller;

import java.util.List;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.ProfitCalculator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.input.InputBonusNumberView;
import lotto.view.input.InputMoneyView;
import lotto.view.input.InputView;
import lotto.view.input.InputWinningNumberView;
import lotto.view.output.OutputView;

public class LottoController {
    OutputView outputView = new OutputView();

    public void start() {
        Money money = getMoney();
        outputView.showTicket(money.getTicket());

        List<Lotto> lottos = getLottos(money);
        outputView.showLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();

        PrizeResult prizeResult = getPrizeResult(lottos, winningLotto);
        outputView.showPrizeResults(prizeResult);

        double profitRatio = getProfitRate(money, prizeResult);
        outputView.showProfitRate(profitRatio);
    }

    private Money getMoney() {
        InputMoneyView inputMoneyView = new InputMoneyView();
        while (true) {
            try {
                int moneyInput = inputMoneyView.getValue();
                return new Money(moneyInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();

        while (true) {
            try {
                return lottoGenerator.generateLottoGroup(money.getTicket());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto getWinningLotto() {
        InputWinningNumberView inputWinningNumberView = new InputWinningNumberView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();
        while (true) {
            List<Integer> winningNumbers = inputWinningNumberView.getValue();
            int bonusNumber = inputBonusNumberView.getValue();

            try {
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
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
