package lotto.Controller;

import lotto.Model.LottoAmount;
import lotto.Model.LottoAmountValidator;
import lotto.View.InputView;

public class InputController {
    public static LottoAmount setAmountOfLotto(){
        LottoAmountValidator validator = new LottoAmountValidator(InputView.inputAmountOfLotto());
        return validator.lottoAmount;
    }
}
