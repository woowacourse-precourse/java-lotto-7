package lottoWinningNumber;

import java.util.Arrays;
import java.util.List;
import validate.LottoPurchaseAmountValidator;

public class LottoWinningNumberDelimiter {
    private final static String LOTTO_WINNING_NUMBER_SEPERATOR = ",";

    private final String lottoWinningNumber;

    public LottoWinningNumberDelimiter(String lottoWinningNumber) {
        this.lottoWinningNumber = lottoWinningNumber;
    }

    public List<String> runAndBringLottoWinningNumber() {
        return delimitLottoWinningNumber();
    }

    private List<String> delimitLottoWinningNumber() {
        List<String> seperatedLottoWinningNumbers = Arrays.stream(
                        lottoWinningNumber.split(LOTTO_WINNING_NUMBER_SEPERATOR))
                .map(String::trim)
                .toList();

        return seperatedLottoWinningNumbers;
    }
}
