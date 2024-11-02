package lotto.controller;

import lotto.model.dto.LottoNumbers;
import lotto.model.dto.WinningStatistics;
import lotto.model.LottoResult;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoMachine;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.WinningLotto;
import lotto.model.lottogenerator.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private Money money;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMachine = new LottoMachine(new RandomLottoNumberGenerator());
    }

    public void play() {
        Lottos lottos = buyLotto();
        WinningLotto winningLotto = getWinningLotto();
        LottoResult lottoResult = extractRank(lottos, winningLotto);
        getResult(lottoResult);
    }

    private Lottos buyLotto() {
        while (true) {
            try {
                money = new Money(inputView.inputMoney());
                final Lottos lottos = lottoMachine.execute(money.calculateLottoCount());
                printBuyingLottos(money, lottos);
                return lottos;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningLotto getWinningLotto() {
        while (true) {
            try {
                final Lotto lotto = new Lotto(inputView.inputLottoNumber());
                final BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
                return new WinningLotto(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoResult extractRank(final Lottos lottos, final WinningLotto winningLotto) {
        final LottoResult lottoResult = new LottoResult();
        for (final Lotto lotto : lottos.getLottos()) {
            int countOfMatch = winningLotto.calculateMatchCount(lotto);
            boolean shotBonus = winningLotto.isContainBonus(lotto);
            Rank rank = Rank.extractRanking(countOfMatch, shotBonus);
            lottoResult.addResult(rank);
        }
        return lottoResult;
    }

    private void getResult(final LottoResult lottoResult) {
        WinningStatistics winningStatistics = new WinningStatistics(lottoResult);
        outputView.printResult(winningStatistics);
        double rate = lottoResult.calculateReturnRate(money);
        outputView.printProfit(rate);
    }

    private void printBuyingLottos(final Money money, final Lottos lottos) {
        outputView.printLottoCount(money.calculateLottoCount());
        LottoNumbers lottoNumbers = new LottoNumbers(lottos);
        outputView.printLottoNumbers(lottoNumbers);
    }
}
