package lotto.controller;

import lotto.model.User;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private User user;
    private LottoService lottoService;

    public void run(){
        beforeLotto();
        //startLotto();
        //afterLotto();
    }

    public void beforeLotto(){
        int buyAmount = InputView.inputBuyAmount();
        user = new User(buyAmount);
        lottoService.buyLottos(user);
    }
}
