package lotto.model;

import static lotto.ExceptionMessage.LOTTO_NUMBER_DUPLICATE_EXCEPTION;
import static lotto.ExceptionMessage.LOTTO_NUMBER_LENGTH_EXCEPTION;
import static lotto.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION;
import static lotto.ExceptionMessage.WINNING_NUMBER_DUPLICATE_EXCEPTION;
import static lotto.ExceptionMessage.WINNING_NUMBER_LENGTH_EXCEPTION;
import static lotto.ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION;

import java.util.List;


public class WinningNumbers {
    private final Lotto winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        try {
            this.winningNumbers = new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            String winningNumbersExceptionMessage = getWinningNumbersExceptionMessage(e.getMessage());
            throw new IllegalArgumentException(winningNumbersExceptionMessage);
        }

    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getLottoNumbers();
    }


    private String getWinningNumbersExceptionMessage(String message) {
        if (message.contains(LOTTO_NUMBER_LENGTH_EXCEPTION.message())) {
            return WINNING_NUMBER_LENGTH_EXCEPTION.message();
        }
        if (message.contains(LOTTO_NUMBER_DUPLICATE_EXCEPTION.message())) {
            return WINNING_NUMBER_DUPLICATE_EXCEPTION.message();
        }
        if (message.contains(LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION.message())) {
            return WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION.message();
        }
        return message;
    }

}
