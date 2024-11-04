package lotto.lottoapp.controller;

import java.util.List;
import lotto.common.util.InteractionRepeatable;
import lotto.lottoapp.business.LottoService;
import lotto.lottoapp.model.WinningLotto;
import lotto.lottoapp.model.value.LottoNumbers;
import lotto.lottoapp.model.value.WinningStatistics;
import lotto.lottoapp.model.value.Won;
import lotto.lottoapp.view.LottoInput;
import lotto.lottoapp.view.LottoOutput;

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
