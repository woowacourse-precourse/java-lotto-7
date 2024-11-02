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
    private int count;
    private BonusNumber bonusNumber;

    public LottoController() {
        this.lottoService = new LottoService();
//        this.lotto = new Lotto(InputView.inputLottoNumbers());
    }

    public void set() {
        this.money = new Money(InputView.inputMoney());

        this.count = lottoService.getTicketCount(money);
        System.out.printf((Prompt.CONFIRM_TICKET_COUNT.getMessage()) + "%n", count);

        this.lottos = new Lottos(count);
        OutputView.printBoughtLottos(lottos);

        this.winningNumber = lottoService.getWinningNumbers();
        this.bonusNumber = lottoService.getBonusNumber();

        calculatePrize();
    }

    private void calculatePrize() {
        long totalPrize = lottoService.getTotalPrize(lottos, winningNumber, bonusNumber);
        double earningRate = calculateEarningRate(totalPrize);
    }

    private double calculateEarningRate(long totalPrize) {
        return (double) totalPrize /  money.getValue() * 100;
    }
}
