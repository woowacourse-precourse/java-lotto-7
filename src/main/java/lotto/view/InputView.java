package lotto.view;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public Integer readPayment() throws IllegalArgumentException {
        String payment = readLine();
        try {
            return Integer.parseInt(payment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매 금액은 정수여야 합니다.");
        }
    }

    public String readWinningNumbers() throws IllegalArgumentException {
        String winningNumbers = readLine();
        if (winningNumbers.matches("^(\\d+)(,( )*\\d+)*$")) {
            return winningNumbers;
        }
        throw new IllegalArgumentException("당첨 번호는 정수이며 쉼표(,)로만 구분되어야 합니다.");
    }

    public Integer readBonusNumber() throws IllegalArgumentException {
        String bonusNumber = readLine();
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 정수여야 합니다.");
        }
    }

    public void closeConsole() {
        close();
    }
}
