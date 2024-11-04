package lotto.controller;

import lotto.controller.service.LottoCreationService;
import lotto.controller.service.LottoGameService;
import lotto.controller.service.WinningLottoService;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottoController {
    private final LottoCreationService lottoCreationService;
    private final WinningLottoService winningLottoService;
    private final LottoGameService lottoGameService;

    public LottoController() {
        this.lottoCreationService = new LottoCreationService();
        this.winningLottoService = new WinningLottoService();
        this.lottoGameService = new LottoGameService();
    }

    public void run() {
        Lottos lottos = lottoCreationService.createLottos();
        WinningLotto winningLotto = winningLottoService.getWinningLotto();
        lottoGameService.playLotto(lottos, winningLotto);
    }
}
