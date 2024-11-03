package lotto;

public class Application {
    public static void main(String[] args) {
        new Application().startLottoGame();
    }

    private void startLottoGame() {
        LottoGame lottoGame = new LottoGame();
        int quantity = getValidPurchaseAmount(lottoGame);

        lottoGame.purchaseLottos(quantity);
        lottoGame.inputWinningNumbers();
        lottoGame.inputBonusNumber();
        lottoGame.calculateAndPrintResults();
    }

    private int getValidPurchaseAmount(LottoGame lottoGame) {
        while (true) {
            try {
                return lottoGame.getPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
