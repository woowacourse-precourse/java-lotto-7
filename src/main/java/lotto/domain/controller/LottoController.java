package lotto.domain.controller;

import lotto.domain.model.lotto.Lotto;
import lotto.domain.model.lotto.LottoService;
import lotto.domain.model.lotto.LottoSummary;
import lotto.domain.model.user.User;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int amount = inputView.getUserPurchaseAmount();
        List<Lotto> lottos = lottoService.issueByAmount(amount);
        User user = User.create(amount, lottos);

        outputView.printLottos(user.getLottos());

        LottoSummary summary = getWinningNumberAndTakeSummary(user);

        outputView.printLottoSummary(summary);
        outputView.printUserProfitRate(user);
    }

    private LottoSummary getWinningNumberAndTakeSummary(User user) {
        Lotto winningNumber = inputView.getWinningNumber();
        int bonusNumber = inputView.getBonusNumber(winningNumber);

        return lottoService.evaluateUserLotto(user, winningNumber, bonusNumber);
    }
}
