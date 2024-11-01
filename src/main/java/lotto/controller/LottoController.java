package lotto.controller;

import lotto.model.LottoPurchase;
import lotto.view.InputReader;

public class LottoController {

    private final InputReader reader;

    public LottoController(final InputReader reader) {
        this.reader = reader;
    }

    public void run() {
        final LottoPurchase lottoPurchase = buyLotto();
    }

    private LottoPurchase buyLotto() {
        while (true) {
            try {
                return reader.purchase();
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }
}
