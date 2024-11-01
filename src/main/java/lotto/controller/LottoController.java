package lotto.controller;

import static lotto.validation.PurchaseAmountValidation.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;


public class LottoController {
    private List<Lotto> lottoTickets;

    public void run() {
        int attemptCount = getAttemptCount();
        printPurchaseLottoCount(attemptCount);
        lottoTickets = generateLotto(attemptCount);

    }

    private List<Lotto> generateLotto(int attemptCount) {
        List<Lotto> lotto = new ArrayList<>();
        for (int count = 1; count <= attemptCount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            printEachLotto(numbers);
            lotto.add(new Lotto(numbers));
        }
        return lotto;
    }

    private int getAttemptCount() {
        printPurchaseAmountInputMessage();
        String purchaseAmount = UserInput();
        return parseValidatedLottoCount(purchaseAmount);
    }
}
