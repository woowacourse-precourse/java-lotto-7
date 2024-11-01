package lotto.domain;

import lotto.util.Parser;
import lotto.util.Validator;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(String winningLottoInput, String bonusNumberInput) {
        Validator.validateWinningNumbers(winningLottoInput, bonusNumberInput);

        this.winningLotto = new Lotto(Parser.parseToIntegerList(winningLottoInput));
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
    }
}
