package lotto.winningNumber.service;

import java.util.Arrays;
import java.util.List;
import lotto.global.util.Parser;
import lotto.lottery.domain.Lotto;
import lotto.winningNumber.domain.WinningNumber;

public class WinningNumberService {

    public WinningNumber create(String number, String bonus) {
        List<Integer> numbers = parseWinningNumbers(number);
        int bonusNumber = Parser.parseToInt(bonus);
        return new WinningNumber(numbers, bonusNumber);
    }

    private List<Integer> parseWinningNumbers(String number) {
        return Arrays.stream(number.split(",")).filter(s -> !s.trim().isEmpty())
                .map(Parser::parseToInt).toList();
    }

    public int calculateMatchCount(Lotto lotto, WinningNumber winningNumber) {
        return (int) lotto.getNumbers().stream()
                .filter(l -> winningNumber.getNumbers().contains(l))
                .count();

    }

    public boolean isBonusMatched(Lotto lotto, WinningNumber winningNumber) {
        return lotto.getNumbers().contains(winningNumber.getBonus());
    }
}
