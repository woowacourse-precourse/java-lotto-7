package lotto;

import lotto.dto.WinningNumbers;
import lotto.game.LottoGame;
import lotto.io.InputHandler;

public class Controller {
    private final InputHandler inputHandler = new InputHandler();
    private final LottoGame lottoGame = new LottoGame();

    public void run() {
        buyLotto();
        playLottoGame();
    }

    private void buyLotto() {
        int lottoPrice = inputHandler.getLottoPrice();
        lottoGame.buyLottos(lottoPrice);
    }

    private void playLottoGame() {
        String selectedNumbers = inputHandler.getSelectedNumbers();
        int bonusNumber = inputHandler.getBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(selectedNumbers, bonusNumber);
        lottoGame.start(winningNumbers);
    }
}
