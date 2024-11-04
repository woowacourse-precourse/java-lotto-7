package lotto.dto;

import lotto.domain.vo.Number;
import lotto.util.NumberParser;

import java.util.List;

public class WinningNumbersRequest {
    private final List<Number> winningNumbers;

    private WinningNumbersRequest(List<Number> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbersRequest from(String winningNumbers) {
        List<Integer> parsedWinningNumbers = NumberParser.parseWinningNumbers(winningNumbers);

        List<Number> realWinningNumbers = parsedWinningNumbers.stream()
                .map(Number::newInstance)
                .toList();

        return new WinningNumbersRequest(realWinningNumbers);
    }

    public List<Number> getWinningNumbers() {
        return winningNumbers;
    }
}
