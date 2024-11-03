package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String amount = Console.readLine();

        validateNotNullOrBlank(amount);
        validateIsNumeric(amount);

        return amount;
    }

    public String readWinningNumber() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String inputWinning = Console.readLine();

        validateNotNullOrBlank(inputWinning);

        return inputWinning;
    }

    public String readBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String inputBonus = Console.readLine();

        validateNotNullOrBlank(inputBonus);

        return inputBonus;
    }

    private void validateNotNullOrBlank(String input) {
        if (input == null || input.isBlank())
            throw new IllegalArgumentException();
    }

    private void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit))
            throw new IllegalArgumentException();
    }
}
