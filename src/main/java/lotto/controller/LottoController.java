package lotto.controller;

import lotto.domain.entity.Lotto;
import lotto.domain.entity.Lottos;
import lotto.domain.generate.RandomLottoNumberGenerator;
import lotto.domain.rank.LottoRankPrize;
import lotto.domain.result.LottoResultChecker;
import lotto.domain.store.LottoStore;
import lotto.ui.input.ConsoleInputView;
import lotto.ui.output.ConsoleOutputView;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;
import lotto.ui.parser.InputParser;

import java.util.List;

public class LottoController {

    private final LottoStore lottoStore;
    private final LottoRankPrize lottoRankPrize;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoStore = new LottoStore(new RandomLottoNumberGenerator());
        this.lottoRankPrize = new LottoRankPrize();
        this.inputView = new ConsoleInputView();
        this.outputView = new ConsoleOutputView();
    }

    public void start() {
        final Lottos lottos = createLottos();

        final LottoResultChecker resultChecker = createResultChecker();

        final Lottos checkedLottosRank = resultChecker.checkLottosRank(lottos);

        final int profit = getProfit(checkedLottosRank);

        outputView.printLottos(checkedLottosRank);
        outputView.winningStats(checkedLottosRank, profit);
    }

    private Lottos createLottos() {
        final int pay = inputView.inputPayment();

        return lottoStore.issueLottos(pay);
    }

    private LottoResultChecker createResultChecker() {
        final List<Integer> winningNumbers = inputView.inputWinningNumbers();
        final int bonusNumber = inputView.inputBonusNumber();

        return new LottoResultChecker(winningNumbers, bonusNumber);
    }

    private int getProfit(final Lottos checkedLottosRank) {
        return lottoRankPrize.calculateTotalPrize(checkedLottosRank);
    }
}
