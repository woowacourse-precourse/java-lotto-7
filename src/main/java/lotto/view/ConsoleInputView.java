package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    @Override
    public String getPurchaseAmountInput() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    @Override
    public String getWinningNumbersInput() {
        System.out.println(WINNING_NUMBERS_PROMPT);
        return Console.readLine();
    }

    @Override
    public String getBonusNumberInput() {
        System.out.println(BONUS_NUMBER_PROMPT);
        return Console.readLine();
    }
}
