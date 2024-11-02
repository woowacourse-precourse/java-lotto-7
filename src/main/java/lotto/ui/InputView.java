package lotto.ui;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.exception.InputException;
import lotto.exception.message.InputExceptionMessage;
import lotto.ui.prompt.Prompt;

public class InputView {

    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final Prompt prompt;

    public InputView(Prompt prompt) {
        this.prompt = prompt;
    }

    public BigDecimal displayReadPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
        try {
            return new BigDecimal(prompt.input());
        } catch (NumberFormatException e) {
            throw new InputException(InputExceptionMessage.INVALID_BIG_DECIMAL_FORMAT);
        }
    }

    public List<Integer> displayReadWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS_MESSAGE);
        return Arrays.stream(prompt.input().split(","))
                .map(number -> Integer.parseInt(number.trim())).toList();
    }

    public int displayReadBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
        try {
            return Integer.parseInt(prompt.input());
        } catch (NumberFormatException e) {
            throw new InputException(InputExceptionMessage.INVALID_INTEGER_FORMAT);
        }
    }

}
