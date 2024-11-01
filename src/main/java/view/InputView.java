package view;

import camp.nextstep.edu.missionutils.Console;
import convert.InputConvertor;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MSG = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요.";
    private final InputConvertor inputConvertor;

    public InputView(InputConvertor inputConvertor) {
        this.inputConvertor = inputConvertor;
    }

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MSG);

        String inputPurchaseAmount = Console.readLine();
        return inputConvertor.convertPurchaseAmount(inputPurchaseAmount);
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MSG);
        return Console.readLine();
    }

    public String InputBonusNumberMsg() {
        System.out.println(INPUT_BONUS_NUMBER_MSG);
        return Console.readLine();
    }
}
