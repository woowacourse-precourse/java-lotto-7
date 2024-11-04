package lotto.util;

public class WinningNumberSeparator {
    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static String[] separatedLottoNumbers(String winningNumbers) {
        return winningNumbers.split(WINNING_NUMBER_DELIMITER);
    }
}
