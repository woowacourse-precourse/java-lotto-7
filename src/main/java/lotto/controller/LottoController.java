package lotto.controller;

import java.util.NoSuchElementException;
import java.util.function.Function;
import lotto.dto.LottoStatisticsDto;
import lotto.dto.LottosDto;
import lotto.model.BonusNumber;
import lotto.model.LottoMachine;
import lotto.model.LottoStatistics;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.utils.RandomLottoNumberGenerationStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        try {
            PurchaseAmount purchaseAmount = getInput(OutputView::printPurchaseAmountInputMessage, PurchaseAmount::from);
            LottoMachine lottoMachine = initializeLottoMachine(purchaseAmount);
            OutputView.printPurchasedLottos(LottosDto.from(lottoMachine.getLottos()));

            WinningNumbers winningNumbers = getInput(OutputView::printWinningNumberInputMessage, WinningNumbers::from);
            BonusNumber bonusNumber = getBonusNumber(winningNumbers);
            LottoStatistics calculate = calculate(lottoMachine, winningNumbers, bonusNumber, purchaseAmount);
            OutputView.printStatistics(LottoStatisticsDto.from(calculate));
        } catch (NullPointerException e) {
            OutputView.printErrorMessage("[ERROR] 입력값이 존재하지 않아 로또가 종료됩니다.");
        }
    }

    private <T> T getInput(Runnable outputMessage, Function<String, T> parser) {
        while (true) {
            try {
                outputMessage.run();
                String input = InputView.readInput();
                return parser.apply(input);
            } catch (NoSuchElementException e) {
                OutputView.printErrorMessage(e.getMessage());
                return null;
            } catch (RuntimeException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoMachine initializeLottoMachine(PurchaseAmount purchaseAmount) {
        return LottoMachine.initializeWith(purchaseAmount.getAmount(), new RandomLottoNumberGenerationStrategy());
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        return getInput(OutputView::printBonusNumberInputMessage,
                input -> BonusNumber.from(input, winningNumbers.getWinningNumbers()));
    }

    private static LottoStatistics calculate(LottoMachine lottoMachine, WinningNumbers winningNumbers,
                                             BonusNumber bonusNumber, PurchaseAmount purchaseAmount) {
        return new LottoStatistics(lottoMachine.getLottos(), winningNumbers, bonusNumber,
                purchaseAmount.getAmount());
    }
}
