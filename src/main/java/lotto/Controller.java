package lotto;

import lotto.dto.BuyingPrice;
import lotto.dto.Buyer;
import lotto.game.LottoCreator;
import lotto.game.LottoGame;
import lotto.game.Lottos;
import lotto.io.InputHandler;

public class Controller {
    private final InputHandler inputHandler = new InputHandler();
    private final LottoCreator lottoCreator = new LottoCreator();

    public void run() {
        LottoGame lottoGame = buyLottos();
        playLottoGame(lottoGame);
    }

    private LottoGame buyLottos() {
        BuyingPrice buyingPrice = inputHandler.getPrice();
        Lottos lottos = lottoCreator.createLottos(buyingPrice.getLottoCount());
        return new LottoGame(buyingPrice, lottos);
    }

    private void playLottoGame(LottoGame lottoGame) {
        Buyer buyer = inputHandler.getBuyer();
        lottoGame.start(buyer);
    }
}
