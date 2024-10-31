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
        this.inputView = new ConsoleInputView(new InputParser());
        this.outputView = new ConsoleOutputView();
    }

    public void start() {
        final int pay = inputView.inputPayment();

        final Lottos lottos = lottoStore.issueLottos(pay);

        final List<Integer> winningNumbers = inputView.inputWinningNumbers();
        final int bonusNumber = inputView.inputBonusNumber();

        final LottoResultChecker resultChecker = new LottoResultChecker(winningNumbers, bonusNumber);

        final List<Lotto> checkedLottosRank = resultChecker.checkLottosRank(lottos);

        final int profit = lottoRankPrize.calculateTotalPrize(checkedLottosRank);

        outputView.printLottos(checkedLottosRank);

        outputView.winningStats(checkedLottosRank, profit);
    }
}
