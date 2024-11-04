package lotto.view;

import static lotto.common.exception.ErrorMessage.INPUT_NULL_OR_EMPTY_ERROR;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_AMOUNT_REQUEST_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_REQUEST_PROMPT = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_PROMPT = "\n보너스 번호를 입력해 주세요.";

    public String getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_PROMPT);
        return validate(Console.readLine().strip());
    }

    public String getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_REQUEST_PROMPT);
        return validate(Console.readLine().strip());
    }

    public String getBonusNumber() {
        System.out.println(BONUS_NUMBER_REQUEST_PROMPT);
        return validate(Console.readLine().strip());
    }

    private String validate(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NULL_OR_EMPTY_ERROR.message());
        }
        return message;
    }
}
