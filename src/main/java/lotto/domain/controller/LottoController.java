package lotto.domain.controller;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoService;
import lotto.domain.model.User;
import lotto.domain.view.InputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, LottoService lottoService) {
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int amount = inputView.getUserPurchaseAmount();
        List<Lotto> lottos = lottoService.issueByAmount(amount);

        User user = User.create(amount, lottos);

        Lotto winningNumber = inputView.getWinningNumber();

        // todo 로또 당첨 확인
    }


}
