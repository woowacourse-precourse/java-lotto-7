package lotto;

import lotto.dto.WinningNumbers;
import lotto.game.LottoGame;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class Controller {
    private final InputHandler inputHandler = new InputHandler();
    private final LottoGame lottoGame = new LottoGame();
    private final static int LOTTO_PRICE = 1000;

    public void run() {
        buyLotto();
        playLottoGame();
    }

    private void buyLotto() {
        int lottoPrice = inputHandler.getLottoPrice();
        int lottoCount = lottoPrice / LOTTO_PRICE;
        OutputHandler.printLottoCount(lottoCount);

        lottoGame.createRandomLottos(lottoCount);
    }

    private void playLottoGame() {
        String selectedNumbers = inputHandler.getSelectedNumbers();
        int bonusNumber = inputHandler.getBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(selectedNumbers, bonusNumber);

        lottoGame.start(winningNumbers);
    }

}
