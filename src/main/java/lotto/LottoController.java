package lotto;

import java.util.List;
import java.util.function.Supplier;

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
        /*
        1. 금액 받아오기
        2. 로또 발행
        3. 추첨
        4. 매치
        5. 통계 보여주기
         */
        Money capital = attempt(() -> new Money(inputView.promptAmount()));
        List<Lotto> lottos = issueLottoesWith(capital);

        List<Rank> ranks = pickLotto().match(lottos);

        statisticsView.printStatistics(new Statistics(ranks), capital);
    }

    private List<Lotto> issueLottoesWith(Money money) {
        List<Lotto> lottos = new Seller().issueLottoesWith(money);
        outputView.printPurchase(lottos);
        outputView.printIssuedLottoes(lottos);
        return lottos;
    }

    private LottoReferee pickLotto() {
        Lotto winningLotto = attempt(() -> new Lotto(inputView.promptWinningNumbers()));
        LottoNumber bonusNumber = attempt(() -> new LottoNumber(inputView.promptBonusNumber()));
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
