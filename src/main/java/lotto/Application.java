package lotto;

import lotto.controller.LottoStatisticController;
import lotto.controller.LottoVendingMachineController;
import lotto.controller.LottoNumberInputController;
import lotto.dto.LottoResultDTO;
import lotto.dto.PurchaseDTO;
import lotto.dto.WinningLottoDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private static PurchaseDTO purchased;

    public static void main(String[] args) {
        useLottoVendingMachine();
        calculateLottoStatistic();
    }

    public static void useLottoVendingMachine() {
        Integer totalCost = inputView.inputSingleInteger(inputView::inputTotalCost);

        purchased = LottoVendingMachineController.buy(totalCost);

        outputView.displayLottoNumbers(purchased.getLottoTickets());
    }

    public static void calculateLottoStatistic() {
        WinningLottoDTO winningLotto = LottoNumberInputController.inputWinningLotto(inputView);
        LottoResultDTO result = LottoStatisticController.calculateResult(winningLotto, purchased);

        outputView.displayLottoStatistic(result.getResult(), result.getProfitPercentage());
    }
}
