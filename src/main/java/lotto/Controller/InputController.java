package lotto.Controller;

import lotto.Model.LottoAmountValidator;
import lotto.View.InputView;

public class InputController {
    public static int setAmountOfLotto(){
        LottoAmountValidator validator = new LottoAmountValidator(InputView.inputAmountOfLotto());
        return validator.lottoAmount;
    }
}
