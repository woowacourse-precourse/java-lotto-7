package lotto;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class Controller {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    public void run() {
        int lottoPrice = inputHandler.getLottoPrice();
        int lottoCount = lottoPrice / 1000;

        LottoGenerator lottoGenerator = new LottoGenerator(lottoCount);

    }

}
