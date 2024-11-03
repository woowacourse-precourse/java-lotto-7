package lotto.controller;

import lotto.dto.LottoEvaluatedStatus;
import lotto.model.Lotto;
import lotto.model.LottoOutlet;
import lotto.model.LottoEvaluator;
import lotto.model.LottoTicket;
import lotto.utils.parser.AmountsParser;
import lotto.utils.parser.BonusNumberParser;
import lotto.utils.parser.WinningNumbersParser;
import lotto.utils.validator.AmountsValidator;
import lotto.utils.validator.BonusNumberValidator;
import lotto.utils.validator.WinningNumbersValidator;
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
        int lottoAmount = readLottoAmount();

        LottoTicket lottoTickets = LottoOutlet.purchaseLottoTickets(lottoAmount);
        printLottoStatus(lottoTickets);

        Lotto winningNumbers = readWinningNumbers();
        int bonusNumbers = readBonusNumber(winningNumbers);

        LottoEvaluator lottoEvaluator = new LottoEvaluator(lottoTickets, winningNumbers, bonusNumbers);
        LottoEvaluatedStatus lottoPrizeStatus = lottoEvaluator.getEvaluatedStatus();

        printLottoResult(lottoPrizeStatus);
    }

    private int readLottoAmount() {
        while (true) {
            try {
                String amounts = inputView.receiveLottoAmounts();
                AmountsValidator.validateLottoAmount(amounts);
                return AmountsParser.getAmounts(amounts);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void printLottoStatus(LottoTicket lottoTickets) {
        outputView.printLottoTicketStatus(lottoTickets);
    }

    private Lotto readWinningNumbers() {
        while (true) {
            try {
                String userWinningNumbers = inputView.receiveWinningNumbers();
                WinningNumbersValidator.validateNumbers(userWinningNumbers);
                return WinningNumbersParser.getWinningNumbers(userWinningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private int readBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                String userBonusNumber = inputView.receiveBonusNumber();
                BonusNumberValidator.validateNumber(userBonusNumber);
                return BonusNumberParser.getBonusNumber(winningNumbers, userBonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void printLottoResult(LottoEvaluatedStatus lottoPrizeStatus) {
        outputView.printPrizeResult(lottoPrizeStatus);
    }
}
