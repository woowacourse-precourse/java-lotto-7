package lotto.controller;

import lotto.enums.InputMessage;
import lotto.exception.handler.LottoErrorHandler;
import lotto.exception.handler.ParseErrorHandler;
import lotto.exception.handler.WinningNumberErrorHandler;
import lotto.model.domain.Lotto;
import lotto.model.vo.WinningNumber;
import lotto.util.StringParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningNumbersController {

    public WinningNumber createWinningNumber() {
        Lotto lotto = inputWinningNumbers();
        return inputBonusNumber(lotto);
    }

    private static Lotto inputWinningNumbers() {
        try {
            String inputWinningNumberInfo = InputView.getInput(InputMessage.INPUT_WINNING_NUMBER);
            return new Lotto(StringParser.toNumbers(inputWinningNumberInfo));
        } catch (ParseErrorHandler | LottoErrorHandler e) {
            OutputView.printError(e);
            return inputWinningNumbers();
        }
    }

    private static WinningNumber inputBonusNumber(Lotto lotto) {
        try {
            String inputBonusNumberInfo = InputView.getInput(InputMessage.INPUT_BONUS_NUMBER);
            Integer bonusNumber = StringParser.toNumber(inputBonusNumberInfo);
            return new WinningNumber(lotto, bonusNumber);
        } catch (ParseErrorHandler | WinningNumberErrorHandler e) {
            OutputView.printError(e);
            return inputBonusNumber(lotto);
        }
    }
}
