package lotto;

import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class LottoController {

    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();
    private final LotteryCashier lotteryCashier = new LotteryCashier();

    public void play() {
        outputHandler.showPriceInputNavigateMessage();
        Price price = inputHandler.getPriceFromUser();

        Lottos lottos = lotteryCashier.purchaseBy(price);
    }
}