package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoInput;
import lotto.view.InputHandler;

public class LottoManager {
    private final InputHandler inputHandler;

    public LottoManager(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void manageLotto() {
        Integer cash = inputHandler.getCash();
        Lotto lotto = inputHandler.getLottoNumber();
        Integer bonus = inputHandler.getBonus();
        LottoInput lottoInput = new LottoInput(cash, lotto, bonus);
    }
}

