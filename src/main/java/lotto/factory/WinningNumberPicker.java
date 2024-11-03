package lotto.factory;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import lotto.util.LottoNumberParser;

public class WinningNumberPicker {
    private static final String DELIMITER = ",";

    public static WinningNumbers createWinningNumbers(String mainNumbers, int bonusNumber) {
        Lotto winningLotto = LottoNumberParser.parseLotto(mainNumbers, DELIMITER);
        return new WinningNumbers(winningLotto, bonusNumber);
    }
}
