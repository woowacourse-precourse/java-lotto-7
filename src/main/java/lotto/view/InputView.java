package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.Result;

import static lotto.util.Validator.validateEmptyString;
import static lotto.util.Validator.validatePositiveNumber;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputAmount = Console.readLine();
        validateEmptyString(inputAmount);
        try {
            return Integer.parseInt(inputAmount);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자문자열이 아닙니다.");
        }
    }
    public static Result inputWinningNumbers() {
        Result result;
        while(true) {
            try{
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumbers = Console.readLine();
                validateEmptyString(winningNumbers);
                result = new Result(winningNumbers);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
    public static void inputBonusNumber(Result result) {
        while(true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String inputNumber = Console.readLine();
            try {
                validateEmptyString(inputNumber);
                int bonusNumber = Integer.parseInt(inputNumber);
                validatePositiveNumber(bonusNumber);
                result.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
