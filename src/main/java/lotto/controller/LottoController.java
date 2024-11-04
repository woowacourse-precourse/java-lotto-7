package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.service.UserService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final UserService userService;
    private final LottoService lottoService;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public LottoController(){
        this.userService = new UserService(inputView, outputView);
        this.lottoService = new LottoService(inputView, outputView);
    }

    public void run() {
        int lottoTickets = userService.inputAmount();
        User user = createUser(lottoTickets);
        Lotto winningLotto = createWinningLotto();
        winningResultView(user, winningLotto);
    }

    private User createUser(int lottoTickets) {
        return userService.priceLotto(lottoTickets);
    }

    private Lotto createWinningLotto() {
        Lotto lotto = lottoService.winningLottoNumbers();
        return lottoService.bonusLottoNumbers(lotto);
    }

    private void winningResultView(User user, Lotto lotto) {
        lottoService.winningResult(user, lotto);
    }
}
