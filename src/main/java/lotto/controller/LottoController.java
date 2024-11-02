package lotto.controller;

import java.util.List;
import lotto.dto.LottoTicketStatus;
import lotto.dto.WinningStatistics;
import lotto.model.Lotto;
import lotto.model.LottoCalculator;
import lotto.model.LottoStore;
import lotto.model.LottoTicket;
import lotto.util.parser.BonusNumberParser;
import lotto.util.parser.PurchaseAmountParser;
import lotto.util.parser.WinningNumberParser;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.PurchaseAmountValidator;
import lotto.util.validator.WinningNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        LottoTicket lottoTicket = LottoStore.purchaseLottoTicket(purchaseAmount);

        printLottoTicketStatus(lottoTicket);

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto);

        LottoCalculator lottoCalculator = new LottoCalculator(winningLotto, bonusNumber);
        WinningStatistics winningStatistics = lottoCalculator.getWinningStatistics(lottoTicket);

        printWinningStatistics(winningStatistics);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String rawPurchaseAmount = inputView.readRawPurchaseAmount();
                int purchaseAmount = PurchaseAmountParser.parseRawPurchaseAmount(rawPurchaseAmount);
                PurchaseAmountValidator.validate(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void printLottoTicketStatus(LottoTicket lottoTicket) {
        LottoTicketStatus lottoTicketStatus = lottoTicket.getLottoTicketStatus();
        outputView.printLottoTicketStatus(lottoTicketStatus);
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                String rawWinningNumbers = inputView.readRawWinningNumbers();
                WinningNumbersValidator.validate(rawWinningNumbers);
                List<Integer> winningNumbers = WinningNumberParser.parseRawWinningNumbers(rawWinningNumbers);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private int getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String rawBonusNumber = inputView.readRawBonusNumber();
                int bonusNumber = BonusNumberParser.parseRawBonusNumber(rawBonusNumber);
                BonusNumberValidator.validate(winningLotto, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void printWinningStatistics(WinningStatistics winningStatistics) {
        outputView.printWinningStatistics(winningStatistics);
    }
}
