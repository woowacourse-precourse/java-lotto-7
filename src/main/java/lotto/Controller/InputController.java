package lotto.Controller;

import java.util.List;
import lotto.Model.BonusNumValidator;
import lotto.Model.LottoAmountValidator;
import lotto.Model.LottoWinningNumberValidator;
import lotto.View.InputView;

public class InputController {
    public static int setAmountOfLotto() {
        LottoAmountValidator validator = new LottoAmountValidator(InputView.inputAmountOfLotto());
        return validator.lottoAmount;
    }

    public static List<Integer> setWinningNums() {
        LottoWinningNumberValidator validator = new LottoWinningNumberValidator(InputView.inputWinningNums());
        return validator.winningNums;
    }

    public static int setBonusNum(List<Integer> winNums) {
        BonusNumValidator validator = new BonusNumValidator(InputView.inputBonusNum(), winNums);
        return validator.bonusNum;
    }
}
