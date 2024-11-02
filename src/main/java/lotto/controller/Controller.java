package lotto.controller;

import lotto.dto.LottoPrizeStatus;
import lotto.model.Lotto;
import lotto.model.LottoOutlet;
import lotto.model.LottoPrizeRanker;
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
        // 1. 로또 구입 금액 입력 받기
        int lottoAmount = readLottoAmount();
        // 2. 로또 구매 하기
        LottoTicket lottoTickets = LottoOutlet.purchaseLottoTickets(lottoAmount);
        // 3. 로또 번호 출력 하기
        printLottoStatus(lottoTickets);
        // 4. 당첨 번호 입력 받기
        Lotto winningNumbers = readWinningNumbers();
        // 5. 보너스 번호 입력 받기
        int bonusNumbers = readBonusNumber(winningNumbers);
        // 6. 로또 확인 하기 -> 수정해야할 부분 
        LottoPrizeRanker lottoPrizeRanker = new LottoPrizeRanker(lottoTickets, winningNumbers, bonusNumbers);
        // 7. 당첨 통계 출력 하기
        LottoPrizeStatus lottoPrizeStatus = lottoPrizeRanker.getPrizeStatus(lottoAmount);
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

    private void printLottoResult(LottoPrizeStatus lottoPrizeStatus) {
        outputView.printPrizeResult(lottoPrizeStatus);
    }
}
