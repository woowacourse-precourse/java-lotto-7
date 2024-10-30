package lotto;

import lotto.controller.LottoSummaryController;
import lotto.controller.LottoStoreController;
import lotto.controller.InputController;
import lotto.dto.LottoResultDTO;
import lotto.dto.PurchaseDTO;
import lotto.dto.WinningLottoDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        PurchaseDTO purchased = LottoStoreController.buy(inputView);
        outputView.displayLottoNumbers(purchased.getLottoTickets());

        WinningLottoDTO winningLotto = InputController.inputWinningLotto(inputView);
        LottoResultDTO result = LottoSummaryController.calculateResult(winningLotto, purchased);
        outputView.displayLottoSummary(result.getResult(), result.getProfitPercentage());
    }
}
