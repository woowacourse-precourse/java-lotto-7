package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_PRICE_PROMPT = "로또 구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";


    public String inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_PROMPT);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        return Console.readLine();
    }
}