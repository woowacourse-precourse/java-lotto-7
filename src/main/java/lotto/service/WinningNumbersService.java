package lotto.service;

import static lotto.parser.InputParser.parseNumbers;

import lotto.model.WinningNumbers;

public class WinningNumbersService {
    public WinningNumbers getWinningNumbers(String inputWinningNumbers) {
        return new WinningNumbers(parseNumbers(inputWinningNumbers));
    }
}
