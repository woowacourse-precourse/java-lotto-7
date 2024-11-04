package print;

import camp.nextstep.edu.missionutils.Console;
import valid.ValidationUserInput;

public class InputRequest {
    ValidationUserInput validationUserInput = new ValidationUserInput();

    public String moneyRequest() {
        boolean isMoneyValid = false;
        String money = "";
        do {
            System.out.println("구입금액을 입력해 주세요.");
            money = Console.readLine();
            isMoneyValid = validationUserInput.validateMoney(money);
        } while (!isMoneyValid);

        return money;
    }

    public String winningNumbersRequest() {
        boolean isWinningNumbersValid = false;
        String winningNumbers = "";
        do {
            System.out.println("당첨 번호를 입력해 주세요.");
            winningNumbers = Console.readLine();
            isWinningNumbersValid = validationUserInput.validateWinningNumbers(winningNumbers);
        } while (!isWinningNumbersValid);

        return winningNumbers;
    }

    public String bonusNumberRequest() {
        boolean isBonusNumberValid = false;
        String bonusNumber = "";
        do {
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = Console.readLine();
            isBonusNumberValid = validationUserInput.validateBonusNumber(bonusNumber);
        } while (!isBonusNumberValid);

        return bonusNumber;
    }
}
