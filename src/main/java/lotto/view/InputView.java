package lotto.view;

import static lotto.constant.MessageConstant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
        String amount = Console.readLine();

        validateNotNullOrBlank(amount);
        validateIsNumeric(amount);

        return amount;
    }

    public String readWinningNumber() {
        System.out.printf(NEWLINE.getMessage());
        System.out.println(INPUT_WINNING_NUMBER.getMessage());
        String inputWinning = Console.readLine();

        validateNotNullOrBlank(inputWinning);

        return inputWinning;
    }

    public String readBonusNumber() {
        System.out.printf(NEWLINE.getMessage());
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
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
