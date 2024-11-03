package lotto;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        try {
            int quantity = lottoGame.getPurchaseAmount();
            lottoGame.purchaseLottos(quantity);
            lottoGame.inputWinningNumbers();
            lottoGame.inputBonusNumber();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
