package lotto;

import lotto.io.OutputHandler;

public class LottoController {

    private final OutputHandler outputHandler = new OutputHandler();

    public void play() {
        outputHandler.showPriceInputNavigateMessage();
    }
}