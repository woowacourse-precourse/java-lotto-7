package lotto.converter;

import lotto.domain.WinningNumber;
import lotto.util.WinningNumberParser;

public class WinningNumberConverter {

    public static WinningNumber toWinningNumber(final String winningNumbers, final String bonusNumber) {
        return new WinningNumber(WinningNumberParser.parseWinningNumber(winningNumbers), bonusNumber);
    }
}
