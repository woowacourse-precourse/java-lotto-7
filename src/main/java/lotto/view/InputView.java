package lotto.view;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class InputView {

    public Integer readPayment() {
        String payment = readLine();
        try {
            return Integer.parseInt(payment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }
    }

    public String readWinningNumbers() {
        String winningNumbers = readLine();
        if (winningNumbers.matches("^([^\\d,]+)(,[^\\d,]+)*$")) {
            return winningNumbers;
        }
        throw new IllegalArgumentException("[ERROR] 번호는 쉼표(,)로 구분되어야 합니다.");
    }

    public void closeConsole() {
        close();
    }
}
