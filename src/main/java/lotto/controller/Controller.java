package lotto.controller;

import java.util.List;
import lotto.dto.LottoTicketStatus;
import lotto.dto.WinningStatistics;
import lotto.model.Lotto;
import lotto.model.LottoCalculator;
import lotto.model.LottoStore;
import lotto.model.LottoTicket;
import lotto.parser.BonusNumberParser;
import lotto.parser.WinningNumberParser;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        LottoTicket lottoTicket = purchaseLottoTicket();
        printLottoTicketStatus(lottoTicket);

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto);

        LottoCalculator lottoCalculator = new LottoCalculator(winningLotto, bonusNumber);
        WinningStatistics winningStatistics = lottoCalculator.getWinningStatistics(lottoTicket);

        printWinningStatistics(winningStatistics);

    }

    private LottoTicket purchaseLottoTicket() {
        while (true) {
            try {
                int purchaseAmount = getPurchaseAmount();
                return LottoStore.purchaseLottoTicket(purchaseAmount);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String rawPurchaseAmount = inputView.readRawPurchaseAmount();
                PurchaseAmountValidator.validate(rawPurchaseAmount);
                return Integer.parseInt(rawPurchaseAmount);
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
