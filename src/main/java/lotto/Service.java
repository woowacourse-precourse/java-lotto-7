package lotto;

public class Service {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Service() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void run() {
        Payment payment = inputHandler.getPayment();
        PurchasedLotto purchasedLotto = PurchasedLotto.from(payment);
        outputHandler.show(purchasedLotto);

        Winning winning = inputHandler.getWinning();
        Bonus bonus = inputHandler.getBonus(winning);

        Result result = Result.from(winning, bonus, purchasedLotto);
        outputHandler.show(result);

        ReturnRate returnRate = ReturnRate.from(result, payment);
        outputHandler.show(returnRate);
    }
}
