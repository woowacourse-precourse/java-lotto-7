package lotto.converter;

import lotto.domain.LottoWinningNumbers;
import lotto.util.WinningNumberParser;

public class LottoWinningNumbersConverter {

    public static LottoWinningNumbers toLottoWinningNumbers(final String winningNumbers, final String bonusNumber) {
        return new LottoWinningNumbers(WinningNumberParser.parseWinningNumber(winningNumbers), bonusNumber);
    }
}
