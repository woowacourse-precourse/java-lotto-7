package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.common.util.InputUtils;
import lotto.controller.response.LottoIssuingResponse;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.PurchaseAmount;
import lotto.model.Winning;
import lotto.model.WinningNumbers;
import lotto.service.LottoIssuingService;
import lotto.service.LottoResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static final String WINNING_NUMBERS_DELIMITER = ",";
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoIssuingService lottoIssuingService;

    public LottoController(InputView inputView, OutputView outputView, LottoIssuingService lottoIssuingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoIssuingService = lottoIssuingService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmountWithRetry();

        List<Lotto> lottoTickets = lottoIssuingService.issueForAmount(purchaseAmount);
        outputView.printLottoTickets(LottoIssuingResponse.from(lottoTickets));

        WinningNumbers winningNumbers = getWinningNumbersWithRetry();
        BonusNumber bonusNumber = getBonusNumberWithRetry();
        LottoResultService lottoResultService = new LottoResultService(winningNumbers, bonusNumber);

        Map<Winning, Integer> winningResults = lottoResultService.getWinningResults(lottoTickets);
        double rateOfReturn = lottoResultService.calculateRateOfReturn(purchaseAmount, winningResults);

        outputView.printWinningResult(winningResults);
        outputView.printRateOfReturn(rateOfReturn);
    }

    private PurchaseAmount getPurchaseAmountWithRetry() {
        try {
            String purchaseAmount = inputView.getPurchaseAmount();
            return PurchaseAmount.from(InputUtils.parseStringToInt(purchaseAmount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return getPurchaseAmountWithRetry();
        }
    }

    private WinningNumbers getWinningNumbersWithRetry() {
        try {
            String numbers = inputView.getWinningNumbers();
            return WinningNumbers.from(
                    InputUtils.splitWithDelimiter(numbers, WINNING_NUMBERS_DELIMITER)
                            .stream()
                            .map(number -> LottoNumber.from(InputUtils.parseStringToInt(number)))
                            .toList()
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbersWithRetry();
        }
    }

    private BonusNumber getBonusNumberWithRetry() {
        try {
            String number = inputView.getBonusNumber();
            return BonusNumber.from(LottoNumber.from(InputUtils.parseStringToInt(number)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumberWithRetry();
        }
    }
}
