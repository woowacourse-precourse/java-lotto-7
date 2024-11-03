package lotto.controller;

import java.util.function.BiConsumer;
import lotto.dto.LottoResult;
import lotto.model.LottoGame;
import lotto.model.win.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.LottoResultView;

public class LottoResultController implements BiConsumer<LottoGame, WinningNumbers> {

    private final LottoService lottoService;

    public LottoResultController() {
        lottoService = new LottoService();
    }

    @Override
    public void accept(LottoGame lottoGame, WinningNumbers winningNumbers) {
        LottoResult result = lottoService.playLotto(lottoGame, winningNumbers);
        LottoResultView view = new LottoResultView(result);
        view.render();
    }
}
