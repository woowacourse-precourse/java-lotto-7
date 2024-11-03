package lottoWinningNumber;

import java.util.Arrays;
import java.util.List;

public class LottoWinningNumberDelimiter {
    private final static String LOTTO_WINNING_NUMBER_SEPERATOR = ",";

    public List<String> runAndBringSeperatedLottoWinningNumbers(String lottoWinningNumber) {
        List<String> seperatedLottoWinningNumbers = Arrays.stream(
                        lottoWinningNumber.split(LOTTO_WINNING_NUMBER_SEPERATOR))
                .map(String::trim)
                .toList();

        return seperatedLottoWinningNumbers;
    }
}
