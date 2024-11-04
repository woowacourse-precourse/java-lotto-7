package lotto;

import java.util.List;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final InputHandler inputHandler;

    public InputView() {
        inputHandler = new InputHandler();
    }

    public int readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return inputHandler.getPurchaseAmount();
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return inputHandler.getWinningNumbers();
    }

    public int readBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return inputHandler.getBonusNumber();
    }
}
