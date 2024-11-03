package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.LottoPurchase;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
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

        final WinningNumbers winningNumbers = winningNumbers();
        final BonusNumber bonusNumber = bonusNumber(winningNumbers);

        final LottoResult result = lottos.check(winningNumbers, bonusNumber);
        writer.lottoResult(result);
        final double incomeRatio = result.getIncomeRatio(lottoPurchase);
        writer.incomeRatio(incomeRatio);
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

    private WinningNumbers winningNumbers() {
        while (true) {
            try {
                return reader.winningNumbers();
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    private BonusNumber bonusNumber(final WinningNumbers winningNumbers) {
        while (true) {
            try {
                return reader.bonusNumber(winningNumbers);
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }
}
