package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.Validator.validateEmptyString;
import static lotto.util.Validator.validatePositiveNumber;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputAmount = Console.readLine();
        validateEmptyString(inputAmount);
        return Integer.parseInt(inputAmount);
    }
    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        validateEmptyString(winningNumbers);
        return winningNumbers;
    }
    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputNumber = Console.readLine();
        validateEmptyString(inputNumber);
        int bonusNumber = Integer.parseInt(inputNumber);
        validatePositiveNumber(bonusNumber);
        return bonusNumber;
    }

}
