package lotto.view;

import static lotto.MessageContainer.RATE_OF_RETURN_MESSAGE;

public class OutputView {
    public void printRateOfReturn(String rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
