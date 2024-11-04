package lotto.parser.business;

import lotto.parser.util.ParseUtils;

import java.util.List;

public class LottoParser {

    public static List<Integer> parseWinningNumbers(String winningNumbers) {
        String[] deletedWinNumbers  = winningNumbers.split(",");
        List<String> trimmedWinNumbers = ParseUtils.removeWhitespaceAndFormat(deletedWinNumbers);
        return ParseUtils.convertToNumbers(trimmedWinNumbers);
    }
}
