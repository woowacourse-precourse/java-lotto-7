package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "\n구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";


    @Override
    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    @Override
    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }


    @Override
    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
