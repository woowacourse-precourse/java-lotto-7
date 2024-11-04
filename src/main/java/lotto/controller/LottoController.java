package lotto.controller;

import java.util.List;
import lotto.domain.dto.LottoResult;
import lotto.service.LottoService;
import lotto.service.dto.SellLotto;
import lotto.view.LottoView;
import lotto.view.dto.BonusNumberDTO;
import lotto.view.dto.LottoBuyDTO;
import lotto.view.dto.WinningNumberDTO;

public class LottoController {

    private final LottoService lottoService;
    private final LottoView lottoView;

    public LottoController(LottoService lottoService, LottoView lottoView) {
        this.lottoService = lottoService;
        this.lottoView = lottoView;
    }

    public void sellLotto() {
        LottoBuyDTO lottoBuyDTO = lottoView.lottoBuyView();
        SellLotto sellLotto = lottoService.sellLotto(lottoBuyDTO.money());

        lottoView.printSellLottos(sellLotto.lottoDetails());
    }

    public void createWinning() {
        WinningNumberDTO winningNumberDTO = lottoView.winningNumberView();
        lottoService.createWinningNumber(winningNumberDTO.winningNumbers());
    }

    public void createBonus() {
        BonusNumberDTO bonusNumberDTO = lottoView.bonusNumberView();
        lottoService.createBonusNumber(bonusNumberDTO.bonusNumber());
    }

    public void result() {
        LottoResult lottoResult = lottoService.compareWinningNumbers();
        lottoView.printLottoResults(lottoResult.history(), lottoResult.returnRate());
    }
}
