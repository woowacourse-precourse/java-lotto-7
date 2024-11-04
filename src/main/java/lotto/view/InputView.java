package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;


public class InputView {

    private static final String PRINT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRINT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int printGetPurchasePrice(Validator validator) {
        while (true) {
            try {
                System.out.println(PRINT_PURCHASE_PRICE);
                String input = Console.readLine();
                return validator.validatePrice(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }



    public String printGetWinningLottoNumber(Validator validator) {
        while (true) {
            try {
                System.out.println(PRINT_WINNING_NUMBER);
                String input = Console.readLine();
                return validator.validateInput(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int printGetBonusNumber(Validator validator, String winningNumber) {
        while (true) {
            try {
                System.out.println();
                System.out.println(PRINT_BONUS_NUMBER);
                String input = Console.readLine();
                return validator.validateBonusNumber(input, winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
