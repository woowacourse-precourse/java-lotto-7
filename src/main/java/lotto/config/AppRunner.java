package lotto.config;

import java.math.BigDecimal;
import java.math.BigInteger;
import lotto.controller.LottoController;
import lotto.domain.LottoReceipt;
import lotto.domain.Winning;
import lotto.domain.WinningLotto;
import lotto.domain.WinningReport;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppRunner {
    private final InputView inputView;
    private final InputValidator inputValidator;
    private final OutputView outputView;
    private final LottoController controller;

    public AppRunner(InputView inputView, InputValidator inputValidator, OutputView outputView, LottoController controller) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.outputView = outputView;
        this.controller = controller;
    }

    public void run() {
        String inputAmount = inputView.requestPurchaseAmount();
        LottoReceipt lottoReceipt = controller.readPurchaseAmount(inputAmount);

        String inputNumbers = inputView.requestWinningLottoNumbers();
        inputValidator.validateDigitAndDelimiterOnly(inputNumbers);

        String inputBonusNumber = inputView.requestBonusNumber();

        WinningLotto winningLotto = controller.readWinningLottoNumbers(inputNumbers, inputBonusNumber);
        WinningReport winningReport = controller.getReport(lottoReceipt, winningLotto);

        String winningDetails = controller.sendWinningDetails(winningReport.getWinningCounts());
        outputView.printWinningDetails(winningDetails);

        BigInteger totalPrize = Winning.tellTotalPrize(winningReport.getWinningCounts());
        BigDecimal rateOfReturn = lottoReceipt.calculateRateOfReturn(totalPrize);
        outputView.printRateOfReturn(rateOfReturn.toString());
    }
}
