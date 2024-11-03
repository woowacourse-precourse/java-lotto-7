package lotto;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        output.purchaseAmount();
        input.purchaseAmount();
        while (!InputValidator.purchaseAmountValidator(input.getPurchaseAmount())) {
            input.purchaseAmount();
        }
        LottoGenerator lottoGenerator = new LottoGenerator(InputValidator.getPurchaseAmount() / 1000);
        output.lottoCountAndNumbers(lottoGenerator);
        output.winningNumbers();
        input.winningNumber();
        while (!InputValidator.winningNumberValidator(input.getWinningNumber())) {
            input.winningNumber();
        }
        output.bonusNumber();
        input.bonusNumber();
        while (!InputValidator.bonusNumberValidator(input.getBonusNumber())) {
            input.bonusNumber();
        }
        WinningCounter winningCounter = new WinningCounter();
        for (Lotto lotto : lottoGenerator.getLottos()) {
            winningCounter.addWinning(lotto.confirmWinning());
        }
        output.winningStatistics(winningCounter);
    }
}
