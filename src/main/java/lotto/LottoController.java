package lotto;

import lotto.domain.Price;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class LottoController {

    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();

    public void play() {
        outputHandler.showPriceInputNavigateMessage();
        Price price = inputHandler.getPriceFromUser();
    }
}