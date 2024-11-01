package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.LottoGame;
import lotto.model.User;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    private User user;
    private LottoGame lottoGame;
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
        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
        lottoGame = new LottoGame(winningNumbers, bonusNumber);
    }
}
