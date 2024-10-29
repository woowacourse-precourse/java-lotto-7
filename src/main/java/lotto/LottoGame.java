package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoGame {

    public void run() {
        do {
            final int purchaseAmount = InputHandler.inputLottoPurchaseAmount();
            final int lottoAmount = purchaseAmount / 1000;
            LottoManager lottoManager = new LottoManager(lottoAmount);
        } while (true);
    }
}
