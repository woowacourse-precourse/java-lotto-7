package lotto.util;

public class SplittingWinningNumbers {
    private static final String STRING_SPLITTER = ",";

    private SplittingWinningNumbers(){

    }
    public static String[] splitWinningNumbers(String winningNumbers){
        return winningNumbers.split(STRING_SPLITTER);
    }
}
