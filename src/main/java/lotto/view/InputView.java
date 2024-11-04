package lotto.view;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoExceptionMessage;

public class InputView {

    public Integer readPayment() {
        String payment = readLine();
        try {
            return Integer.parseInt(payment);
        } catch (NumberFormatException e) {
            OutputView.printExceptionMessage(LottoExceptionMessage.INTEGER_PAYMENT);
            return readPayment();
        }
    }

    public List<Integer> readWinningNumbers() {
        String winningNumbers = readLine();
        while (!winningNumbers.matches("^(\\d+)(,( )*\\d+)*$")) {
            OutputView.printExceptionMessage(LottoExceptionMessage.FORMATTED_WINNING_NUMBERS);
            winningNumbers = readLine();
        }
        return Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).toList();
    }

    public Integer readBonusNumber() {
        String bonusNumber = readLine();
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            OutputView.printExceptionMessage(LottoExceptionMessage.INTEGER_BONUS_NUMBER);
            return readBonusNumber();
        }
    }

    public void closeConsole() {
        close();
    }
}
