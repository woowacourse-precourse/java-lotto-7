package lotto.controller;

import static lotto.validation.PurchaseAmountValidation.*;
import static lotto.validation.WinningNumberValidation.parseValidatedBonusNumber;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoTickets;
import lotto.model.WinningLotto;
import lotto.validation.WinningNumberValidation;


public class LottoController {

    public void run() {
        int attemptCount = getAttemptCount();
        printPurchaseLottoCount(attemptCount);

        LottoTickets lottoTickets = new LottoTickets(attemptCount);
        WinningLotto winningLotto = createWinningLotto();

    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber(winningNumber);
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private int getBonusNumber(List<Integer> winningNumber) {
        printBonusNumberInputMessage();
        String bonusNumber = UserInput();
        return parseValidatedBonusNumber(bonusNumber, winningNumber);
    }

    private int getAttemptCount() {
        printPurchaseAmountInputMessage();
        String purchaseAmount = UserInput();
        return parseValidatedLottoCount(purchaseAmount);
    }

    private List<Integer> getWinningNumber() {
        printWinningNumberInputMessage();
        String winningNumber = UserInput();
        return WinningNumberValidation.parseValidatedWinningNumber(winningNumber);
    }
}
