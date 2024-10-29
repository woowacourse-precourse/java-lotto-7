package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.util.Validator;
import lotto.view.InputHandler;

public class LottoController {

    public void run() {
        Money money = getMoney();
        WinningLotto winningLotto = getWinningLotto();
    }

    private Money getMoney() {
        InputHandler inputHandler = new InputHandler(new Validator());
        int givenMoney = inputHandler.getInputForPurchaseMoney();
        return new Money(givenMoney);
    }

    private WinningLotto getWinningLotto() {
        InputHandler inputHandler = new InputHandler(new Validator());
        List<Integer> winningLottoNumbers = inputHandler.getInputForWinningNumber();
        Integer bonusNumber = inputHandler.getInputForBonusNumber();
        return new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
    }
}
