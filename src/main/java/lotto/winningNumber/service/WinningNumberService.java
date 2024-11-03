package lotto.winningNumber.service;

import java.util.Arrays;
import java.util.List;
import lotto.global.util.Parser;
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

}
