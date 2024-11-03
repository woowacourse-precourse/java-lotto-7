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

    public void run(){
        int lottoTickets  = userService.inputAmount();
        User user = userService.priceLotto(lottoTickets);
        Lotto lotto = lottoService.winningLottoNumbers();
        lotto = lottoService.bonusLottoNumbers(lotto);
        System.out.println(lotto.getNumbers());
    }
}
