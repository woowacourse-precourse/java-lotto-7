package lotto.view;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public Integer readPayment() {
        String payment = readLine();
        try {
            return Integer.parseInt(payment);
        } catch (NumberFormatException e) {
            OutputView.printExceptionMessage("구매 금액은 정수여야 합니다.");
            return readPayment();
        }
    }

    public String readWinningNumbers() {
        String winningNumbers = readLine();
        while (!winningNumbers.matches("^(\\d+)(,( )*\\d+)*$")) {
            OutputView.printExceptionMessage("당첨 번호는 정수이며 쉼표(,)로만 구분되어야 합니다.");
            winningNumbers = readLine();
        }
        return winningNumbers;
    }

    public Integer readBonusNumber() {
        String bonusNumber = readLine();
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            OutputView.printExceptionMessage("보너스 번호는 정수여야 합니다.");
            return readBonusNumber();
        }
    }

    public void closeConsole() {
        close();
    }
}
