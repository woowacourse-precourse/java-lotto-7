package lotto.ui;

import java.util.Arrays;
import java.util.List;
import lotto.exception.InputException;
import lotto.exception.message.InputExceptionMessage;

public class InputView {

    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final Prompt prompt;

    public InputView(Prompt prompt) {
        this.prompt = prompt;
    }

    public int displayReadPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
        return parseInt();
    }

    public List<Integer> displayReadWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS_MESSAGE);
        return Arrays.stream(this.prompt.input().split(","))
                .map(number -> Integer.parseInt(number.trim())).toList();
    }

    public int displayReadBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
        return parseInt();
    }

    private int parseInt() {
        try {
            return Integer.parseInt(this.prompt.input());
        } catch (NumberFormatException e) {
            throw new InputException(InputExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }

}
