package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            int money = InputProcessor.getPurchaseAmount();
            LottoGame game = new LottoGame(money);
            game.printLottos();

            Lotto winningLotto = InputProcessor.getWinningLotto();
            int bonusNumber = InputProcessor.getBonusNumber(winningLotto.getNumbers());

            game.checkWinningLottos(winningLotto, bonusNumber);
            game.printWinningStatistics();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}