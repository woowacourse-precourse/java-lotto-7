package lotto;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입급액을 입력해 주세요.";
    private final InputHandler inputHandler;

    public InputView() {
        inputHandler = new InputHandler();
    }

    public int readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return inputHandler.getPurchaseAmount();
    }
}
