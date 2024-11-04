package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getAmount() {
        System.out.println(InputViewMessage.AMOUNT_OF_MONEY.getMessage());
        String amount = Console.readLine();
        validateNull(amount);
        return amount;
    }

    public String getAnswer() {
        System.out.println();
        System.out.println(InputViewMessage.ANSWER_LOTTO_NUMBER.getMessage());
        String answer = Console.readLine();
        validate(answer);
        return answer;
    }

    public String getBonusNumber() {
        System.out.println();
        System.out.println(InputViewMessage.BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();
        validate(bonusNumber);
        return bonusNumber;
    }

    private void validate(final String input) {
        validateNull(input);
        validateBlank(input);
    }

    private void validateNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getMessage());
        }
    }

    private void validateBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getMessage());
        }
    }
}

