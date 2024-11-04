package lotto.lottoMachine.lottoWinningNumber;

import java.util.Arrays;
import java.util.List;

public class LottoWinningNumberDelimiter {
    private static final String LOTTO_WINNING_NUMBER_SEPERATOR = ",";

    public List<String> getSeperatedLottoWinningNumbers(String lottoWinningNumber) {
        List<String> seperatedLottoWinningNumbers = Arrays.stream(
                        lottoWinningNumber.split(LOTTO_WINNING_NUMBER_SEPERATOR))
                .map(String::trim)
                .toList();

        return seperatedLottoWinningNumbers;
    }
}
