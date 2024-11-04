package lotto.view;

import static lotto.MessageContainer.NOTICE_ISSUED_LOTTO_QUANTITY;
import static lotto.MessageContainer.RATE_OF_RETURN_MESSAGE;
import static lotto.MessageContainer.WINNING_STATISTICS;
import static lotto.view.ViewConstants.NEW_LINE;

import java.math.BigInteger;

public class OutputView {
    public void printIssuedLottoQuantity(BigInteger lottoQuantity) {
        System.out.printf(NEW_LINE + NOTICE_ISSUED_LOTTO_QUANTITY + NEW_LINE, lottoQuantity);
    }

    public void printWinningDetails(String winningDetails) {
        System.out.println(NEW_LINE + WINNING_STATISTICS);
        System.out.println(winningDetails);
    }

    public void printRateOfReturn(String rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
