package lotto.controller;

import lotto.constant.Prompt;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private Lotto winningNumber;
    private Lottos lottos;
    private Money money;
    private BonusNumber bonusNumber;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void set() {

        buyingLottos();

        inputWinningNumbersAndBonusNumber();

        calculatePrize();
    }

    private void buyingLottos() {
        this.money = new Money(InputView.inputMoney());

        this.lottos = lottoService.buyLottos(money);

        OutputView.printBoughtLottos(lottos, money);
    }

    private void inputWinningNumbersAndBonusNumber() {
        this.winningNumber = lottoService.getWinningNumbers();
        this.bonusNumber = lottoService.getBonusNumber();
    }

    private void calculatePrize() {
        long totalPrize = lottoService.getTotalPrize(lottos, winningNumber, bonusNumber);
        double earningRate = lottoService.calculateEarningRate(totalPrize, money);
    }

}
