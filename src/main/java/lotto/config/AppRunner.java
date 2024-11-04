package lotto.config;

import static lotto.view.ViewConstants.NEW_LINE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.LottoReceipt;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
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

        List<String> lottoDetails = controller.sendLottoDetails(lottoReceipt);

        outputView.printIssuedLottoQuantity(lottoDetails.get(0));
        outputView.printIssuedLottoDetails(lottoDetails.get(1));

        return lottoReceipt;
    }

    private WinningLotto drawWinningLotto() {
        LottoTicket winningTicket = readWinningNumbers();
        return getWinningLotto(winningTicket);
    }

    private void announceWinningResult(LottoReceipt lottoReceipt, WinningLotto winningLotto) {
        List<String> winningResults = controller.sendWinningResult(lottoReceipt, winningLotto);

        outputView.printWinningDetails(winningResults.get(0));
        outputView.printRateOfReturn(winningResults.get(1));
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