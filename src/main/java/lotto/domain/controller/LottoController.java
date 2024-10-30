package lotto.domain.controller;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoService;
import lotto.domain.model.User;
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

        Lotto winningNumber = inputView.getWinningNumber();
        int bonusNumber = inputView.getBonusNumber();
        lottoService.logic(user, winningNumber, bonusNumber);
    }


}
