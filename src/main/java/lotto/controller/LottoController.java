package lotto.controller;

import lotto.model.LottoStatistics;
import lotto.model.LottoTickets;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            outputView.printInputPurchaseAmount();
            int purchaseAmount = inputView.getPurchaseAmount(); // 여기서 예외 발생 가능
            PurchaseAmountValidator.validateAmount(purchaseAmount);
            LottoTickets lottoTickets = lottoService.purchaseLotto(purchaseAmount); // 예외 발생 가능

            outputView.printOutputLottoCount(lottoTickets.getLottoCount());
            outputView.printOutputLottoNumbers(lottoTickets.getLottos());

            outputView.printInputWinnerNumber();
            List<Integer> winningNumber = inputView.getWinningNumbers();

            outputView.printInputBonusNumber();
            int bonusNumber = inputView.getBonusNumber();

            WinningNumbers winningNumbers = new WinningNumbers(winningNumber, bonusNumber);

            LottoStatistics lottoStatistics = new LottoStatistics();
            lottoStatistics.calculateStatistics(lottoTickets.getLottos(), winningNumbers);

            outputView.printOutputLottoStatistics(lottoStatistics.getResultMap());
            double profit = lottoStatistics.calculateProfit(lottoTickets.getPurchaseAmount());
            outputView.printOutputProfit(profit);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 메시지 출력
        }
    }

}
