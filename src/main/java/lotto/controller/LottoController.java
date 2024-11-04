package lotto.controller;

import java.util.NoSuchElementException;
import java.util.function.Function;
import lotto.constants.ErrorMessages;
import lotto.dto.LottoStatisticsDto;
import lotto.dto.LottosDto;
import lotto.model.BonusNumber;
import lotto.model.LottoMachine;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.utils.RandomLottoNumberGenerationStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        try {
            PurchaseAmount purchaseAmount = getInput(OutputView::printPurchaseAmountInputMessage, PurchaseAmount::from);
            Lottos lottoTickets = purchaseLottoTickets(purchaseAmount);
            OutputView.printPurchasedLottos(LottosDto.from(lottoTickets));

            WinningNumbers winningNumbers = getInput(OutputView::printWinningNumberInputMessage, WinningNumbers::from);
            BonusNumber bonusNumber = getBonusNumber(winningNumbers);
            LottoStatistics calculate = calculate(lottoTickets, winningNumbers, bonusNumber, purchaseAmount);
            OutputView.printStatistics(LottoStatisticsDto.from(calculate));
        } catch (NoSuchElementException e) {
            OutputView.printErrorMessage(ErrorMessages.IMPOSSIBLE_SITUATION.formatMessage());
        }
    }

    private <T> T getInput(Runnable outputMessage, Function<String, T> parser) {
        while (true) {
            try {
                outputMessage.run();
                String input = InputView.readInput();
                return parser.apply(input);
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException(e.getMessage());
            } catch (RuntimeException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lottos purchaseLottoTickets(PurchaseAmount purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine();

        return lottoMachine.generateLottos(purchaseAmount.getAmount(), new RandomLottoNumberGenerationStrategy());
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        return getInput(OutputView::printBonusNumberInputMessage,
                input -> BonusNumber.from(input, winningNumbers.getWinningNumbers()));
    }

    private static LottoStatistics calculate(Lottos lottoTickets, WinningNumbers winningNumbers,
                                             BonusNumber bonusNumber, PurchaseAmount purchaseAmount) {
        return new LottoStatistics(lottoTickets, winningNumbers, bonusNumber,
                purchaseAmount.getAmount());
    }
}
