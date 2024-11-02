package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Won;
import lotto.dto.LottoPaper;
import lotto.generator.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public LottoPaper buy() {
        Won fee = new Won(InputView.readFee());
        LottoStore store = new LottoStore(new RandomLottoNumberGenerator());
        LottoPaper paper = store.buy(fee);

        OutputView.renderPaper(paper);
        return paper;
    }

    public void match(LottoPaper lottoPaper) {
        Lotto lotto = Lotto.fromString(InputView.readWinningNumbers());
    }
}
