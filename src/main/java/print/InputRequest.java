package print;

import camp.nextstep.edu.missionutils.Console;
import valid.ValidationUserInput;

public class InputRequest {
    ValidationUserInput validationUserInput = new ValidationUserInput();

    public Integer moneyRequest() {
        Integer money = -1;
        String userInputMoney = "";
        do {
            System.out.println("구입금액을 입력해 주세요.");
            userInputMoney = Console.readLine();
            money = validationUserInput.validateMoney(userInputMoney);
        } while (money == -1);

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
        Integer validBonusNumber = -1;
        String bonusNumber = "";
        do {
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = Console.readLine();
            validBonusNumber = validationUserInput.validateBonusNumber(bonusNumber);
        } while (validBonusNumber == -1);

        return bonusNumber;
    }
}
