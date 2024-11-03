package lotto.io;

public class LottoIOHandler {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public int askLottoPurchaseAmount() {
        outputHandler.askLottoPurchaseAmount();
        return inputHandler.getLottoPurchaseAmount();
    }
}
