package lotto.controller;

import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

public class LottoController {

    private final InputReader reader;
    private final OutputWriter writer;

    public LottoController(final InputReader reader, final OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void buy() {
        final LottoPurchase lottoPurchase = purchaseLotto();
        final Lottos lottos = createLotto(lottoPurchase);
        writer.purchasedLottos(lottoPurchase, lottos);
    }

    private LottoPurchase purchaseLotto() {
        while (true) {
            try {
                return reader.purchase();
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    private Lottos createLotto(final LottoPurchase purchase) {
        return Lottos.createAuto(purchase.getLottoCount());
    }
}
