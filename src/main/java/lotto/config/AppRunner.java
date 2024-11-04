package lotto.config;

import static lotto.view.ViewConstants.NEW_LINE;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.math.BigInteger;
import lotto.controller.LottoController;
import lotto.domain.LottoReceipt;
import lotto.domain.LottoTicket;
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

    public AppRunner(InputView inputView, InputValidator inputValidator,
                     OutputView outputView, LottoController controller) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.outputView = outputView;
        this.controller = controller;
    }

    public void run() {
        LottoReceipt lottoReceipt = sellLottos();
        WinningLotto winningLotto = drawWinningLotto();
        announceWinningResult(lottoReceipt, winningLotto);
        Console.close();
    }

    private LottoReceipt sellLottos() {
        LottoReceipt lottoReceipt = readPurchaseAmount();

        BigInteger lottoQuantity = lottoReceipt.getIssuedLottoQuantity();
        outputView.printIssuedLottoQuantity(lottoQuantity);

        String lottoDetails = lottoReceipt.toString();
        outputView.printIssuedLottoDetails(lottoDetails);

        return lottoReceipt;
    }

    private WinningLotto drawWinningLotto() {
        LottoTicket winningTicket = readWinningNumbers();
        return getWinningLotto(winningTicket);
    }

    private void announceWinningResult(LottoReceipt lottoReceipt, WinningLotto winningLotto) {
        WinningReport winningReport = controller.getReport(lottoReceipt, winningLotto);
        String winningDetails = controller.sendWinningDetails(winningReport.getWinningCounts());
        outputView.printWinningDetails(winningDetails);

        BigInteger totalPrize = Winning.tellTotalPrize(winningReport.getWinningCounts());
        BigDecimal rateOfReturn = lottoReceipt.calculateRateOfReturn(totalPrize);
        outputView.printRateOfReturn(rateOfReturn.toString());
    }

    private LottoReceipt readPurchaseAmount() {
        LottoReceipt lottoReceipt;
        while (true) {
            String inputAmount = inputView.requestPurchaseAmount();
            try {
                inputValidator.validateDigitOnly(inputAmount);
                lottoReceipt = controller.readPurchaseAmount(inputAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + NEW_LINE);
                continue;
            }
            break;
        }
        return lottoReceipt;
    }

    private LottoTicket readWinningNumbers() {
        LottoTicket lottoTicket;
        while (true) {
            String inputNumbers = inputView.requestWinningNumbers();
            try {
                inputValidator.validateDigitAndDelimiterOnly(inputNumbers);
                lottoTicket = controller.readWinningNumbers(inputNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return lottoTicket;
    }

    private WinningLotto getWinningLotto(LottoTicket winningTicket) {
        WinningLotto winningLotto;
        while (true) {
            int bonusNumber = readBonusNumber();
            try {
                winningLotto = controller.getWinningLotto(winningTicket, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return winningLotto;
    }

    private int readBonusNumber() {
        int bonusNumber;
        while (true) {
            String inputNumber = inputView.requestBonusNumber();
            try {
                inputValidator.validateDigitOnly(inputNumber);
                bonusNumber = controller.toInt(inputNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return bonusNumber;
    }
}