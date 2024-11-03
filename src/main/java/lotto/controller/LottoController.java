package lotto.controller;

import java.util.List;
import lotto.business.LottoService;
import lotto.common.controller.InteractionRepeatable;
import lotto.model.WinningLotto;
import lotto.value.LottoNumbers;
import lotto.value.WinningStatistics;
import lotto.value.Won;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController implements InteractionRepeatable {

    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;
    private final LottoService lottoService;

    public LottoController(LottoInput lottoInput,
                           LottoOutput lottoOutput,
                           LottoService lottoService) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
        this.lottoService = lottoService;
    }

    public void doHandleLotto() {
        handleLottoTrade();
        handleLottoWinningProcess();
    }

    private void handleLottoTrade() {
        List<LottoNumbers> issuedLottoNumbers = supplyWithTry(() -> {
            Won wonOfPurchased = lottoInput.askForPurchasePrice();
            return lottoService.buyLotto(wonOfPurchased);
        });
        lottoOutput.showIssuedLottoNumbers(issuedLottoNumbers);
    }

    private void handleLottoWinningProcess() {
        WinningStatistics winningStatistics = supplyWithTry(() -> {
            WinningLotto winningLotto = lottoInput.askForWinningLotto();
            return lottoService.checkWinningResults(winningLotto);
        });
        lottoOutput.announceWinningStatistics(winningStatistics);
    }

}
