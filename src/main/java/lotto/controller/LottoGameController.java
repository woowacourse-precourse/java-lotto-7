package lotto.controller;

import lotto.service.LottoGame;
import lotto.service.LottoSeller;
import lotto.model.UserLottos;
import lotto.model.WinningLotto;

public class LottoGameController {
    private final LottoSeller lottoSeller;
    private final LottoGame lottoGame;

    public LottoGameController() {
        this.lottoSeller = new LottoSeller();
        this.lottoGame = new LottoGame();
    }

    public void run() {
        UserLottos userLottos = lottoSeller.sell();
        WinningLotto winningLotto = lottoGame.generateWinningLotto();
        lottoGame.announceResult(userLottos, winningLotto);
    }
}
