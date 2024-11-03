package lotto;

public class OperationManager {
    private final IO io = new IO();

    public void buy() {
        String payment = io.readPayment();
        String winningNumber = io.readWinningNumber();
        String bonusNumber = io.readBonusNumber();
    }

    public void result() {
        // TODO: result 전달
        io.printResult(result);
    }
}
