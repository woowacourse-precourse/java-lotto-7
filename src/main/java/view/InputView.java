package view;

import camp.nextstep.edu.missionutils.Console;
import validation.Validation;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public InputView() {

    }

    public int purchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine().strip();
        validateInput(input);
        return Integer.parseInt(input);
    }

    public String winingNumber() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return Console.readLine().strip();
    }

    public String bonusNum() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine().strip();
    }

    private static void validateInput(String str) {
        Validation.blankInput(str);
        Validation.numberInput(str);
    }
}
