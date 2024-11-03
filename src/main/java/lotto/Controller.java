package lotto;

import lotto.dto.WinningNumbers;
import lotto.game.LottoCreator;
import lotto.game.LottoGame;
import lotto.game.Lottos;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class Controller {
    private final static int LOTTO_PRICE = 1000;
    private final InputHandler inputHandler = new InputHandler();
    private final LottoCreator lottoCreator = new LottoCreator();

    public void run() {
        LottoGame lottoGame = buyLottos();
        playLottoGame(lottoGame);
    }

    private LottoGame buyLottos() {
        int buyingPrice = inputHandler.getLottoPrice();
        Lottos lottos = lottoCreator.createLottos(getLottoCount(buyingPrice));
        return new LottoGame(buyingPrice, lottos);
    }

    private int getLottoCount(int buyingPrice) {
        int lottoCount = buyingPrice / LOTTO_PRICE;
        OutputHandler.printLottoCount(lottoCount);
        return lottoCount;
    }

    private void playLottoGame(LottoGame lottoGame) {
        String selectedNumbers = inputHandler.getSelectedNumbers();
        int bonusNumber = inputHandler.getBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(selectedNumbers, bonusNumber);
        lottoGame.start(winningNumbers);
    }
}
