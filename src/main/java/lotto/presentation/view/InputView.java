package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "\n당첨 번호를 입력해 주세요 (쉼표로 구분).";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine().trim();
    }

    public String inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT);
        return Console.readLine().trim();
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        return Console.readLine().trim();
    }
}
