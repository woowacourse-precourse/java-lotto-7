package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_BLANK = "입력값이 비어있습니다.";
    private static final String INPUT_NOT_NUM = "입력값이 양수가 아닙니다.";

    public int readPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE);
        String input = Console.readLine();
        return parsePurchasePrice(input);
    }

    public String readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMS);
        String input = Console.readLine();
        validateNullOrEmpty(input);
        return input;
    }

    private int parsePurchasePrice(final String input) {
        validateNullOrEmpty(input);
        return parseInputToNum(input);
    }

    private void validateNullOrEmpty(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_BLANK);
        }
    }

    private int parseInputToNum(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_NUM);
        }
    }

}
