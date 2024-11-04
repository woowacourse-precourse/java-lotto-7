package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.constant.Rank;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoReferee;
import lotto.model.Money;
import lotto.model.Statistics;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.StatisticsView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StatisticsView statisticsView;


    public LottoController(InputView inputView, OutputView outputView, StatisticsView statisticsView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.statisticsView = statisticsView;
    }

    public void play() {
        Money capital = attempt(() -> new Money(inputView.readPurchaseAmount()));
        List<Lotto> lottos = issueLottosWith(capital);

        List<Rank> ranks = attempt(() -> drawLotto().match(lottos));

        statisticsView.printStatistics(new Statistics(ranks), capital);
    }

    private List<Lotto> issueLottosWith(Money money) {
        List<Lotto> lottos = new LottoMachine().issueLottosWith(money);
        outputView.printHowMany(lottos);
        outputView.printIssuedLottos(lottos);
        return lottos;
    }

    private LottoReferee drawLotto() {
        Lotto winningLotto = attempt(() -> new Lotto(inputView.readWinningNumbers()));
        LottoNumber bonusNumber = attempt(() -> new LottoNumber(inputView.readBonusNumber()));
        return new LottoReferee(winningLotto, bonusNumber);
    }

    private <T> T attempt(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return attempt(inputSupplier);
        }
    }
}
