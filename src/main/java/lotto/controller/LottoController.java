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
import lotto.model.WinningLotto;
import lotto.validation.WinningNumberValidation;


public class LottoController {
    private static final List<Lotto> lottoTickets = new ArrayList<Lotto>();

    public void run() {
        int attemptCount = getAttemptCount();
        printPurchaseLottoCount(attemptCount);
        generateLotto(attemptCount);
        WinningLotto winningLotto = new WinningLotto(getWinningNumber(),getBonusNumber());
    }

    private int getBonusNumber() {
        printBonusNumberInputMessage();
        String bonusNumber = UserInput();
        return parseValidatedBonusNumber(bonusNumber);
    }


    private void generateLotto(int attemptCount) {
        for (int count = 1; count <= attemptCount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            printEachLotto(numbers);
            lottoTickets.add(new Lotto(numbers));
        }
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
