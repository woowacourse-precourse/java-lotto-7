package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoGenerator = new LottoGenerator();
    }

    public void getStartLotto() {
        try {
            Money money = new Money(inputView.getValue());
            Lottos lottos = lottoGenerator.createLottos(money.getTicket());

            outputView.printBuyLotto(money);
            outputView.printLottos(lottos);

            WinningLotto winningLotto = createWinningLotto();
            LottoStatistic statistic = new LottoStatistic(lottos, winningLotto, money.getMoney());

            outputView.printWinningStatistic(statistic);
            outputView.printProfitRate(statistic.calculateProfitRate());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private WinningLotto createWinningLotto() {
        List<LottoNumber> winningNumbers = inputView.getLottoNumber().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(inputView.getBonusLottoNumber());
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
