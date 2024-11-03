package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.WinningLotto;
import lotto.domain.Won;
import lotto.dto.LottoPaper;
import lotto.generator.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoStore store = new LottoStore(new RandomLottoNumberGenerator());

    public LottoPaper buy() {
        LottoPaper paper = lottoPaper();

        OutputView.renderPaper(paper);
        return paper;
    }

    private LottoPaper lottoPaper() {
        return retryOnException(() -> store.buy(new Won(InputView.readFee())));
    }

    public void match(LottoPaper lottoPaper) {
        Lotto lotto = lotto();
        WinningLotto winningLotto = winningLotto(lotto);

        OutputView.renderStatistics(lottoPaper, lottoPaper.match(winningLotto));
    }

    private static Lotto lotto() {
        return retryOnException(() -> Lotto.fromString(InputView.readWinningNumbers()));
    }

    private static WinningLotto winningLotto(Lotto lotto) {
        return retryOnException(() -> {
            int bonus = InputView.readBonusNumber();
            return new WinningLotto(lotto, bonus);
        });
    }

    private static <T> T retryOnException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.renderError(e.getMessage());
            }
        }
    }
}
