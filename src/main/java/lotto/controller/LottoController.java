package lotto.controller;

import lotto.domain.AutoLotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final LottoService lottoService;
    private final OutputView outputView;

    public LottoController(InputView inputView, LottoService lottoService, OutputView outputView) {
        this.inputView = inputView;
        this.lottoService = lottoService;
        this.outputView = outputView;
    }

    public void run() {
        List<AutoLotto> autoLottos = getValidAutoLottoOrRepeat();
        outputView.lottoCount(autoLottos.stream().count());
        outputView.lottos(autoLottos);
        WinningLotto winningLotto = getWinningLottoOrReapeat();
        setWinningLottoBonusNumberOrRepeat(winningLotto);
        outputView.winningResult(lottoService.calculateResults(autoLottos, winningLotto));
        outputView.winningStatisticst(lottoService.calculateWinningStatistics(lottoService.calculateResults(autoLottos, winningLotto), autoLottos));
    }

    private List<AutoLotto> getValidAutoLottoOrRepeat() {
        while (true) {
            try {
                String inputLottoPrice = inputView.getLottoPriceByUser();
                return lottoService.createAutoLottosByLottoPrice(inputLottoPrice);
            } catch (IllegalArgumentException e) {
                outputView.error(e.getMessage());
            }
        }
    }

    private WinningLotto getWinningLottoOrReapeat() {
        while (true) {
            try {
                String inputWinningLottoNumbers = inputView.getWinningLottoNumbers();
                return lottoService.createWinningLotto(inputWinningLottoNumbers);
            } catch (IllegalArgumentException e) {
                outputView.error(e.getMessage());
            }
        }
    }

    private WinningLotto setWinningLottoBonusNumberOrRepeat(WinningLotto winningLotto) {
        while (true) {
            try {
                String inputWinningLottoBonusNumber = inputView.getWinningLottoBonusNumber();
                return lottoService.setWinningLottoBonusNumber(winningLotto, inputWinningLottoBonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.error(e.getMessage());
            }
        }
    }






}
