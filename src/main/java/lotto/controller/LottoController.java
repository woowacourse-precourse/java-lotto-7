package lotto.controller;

import static lotto.validation.PurchaseAmountValidation.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;


public class LottoController {
    private List<Lotto> lottoTickets;

    public void run() {
        int attemptCount = getAttemptCount();
        lottoTickets = initLottos(attemptCount);
    }

    private List<Lotto> initLottos(int attemptCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 1; i <= attemptCount; i++) {
            List<Integer> numbers = LottoNumberGenerator.generate();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private int getAttemptCount() {
        printPurchaseAmountInputMessage();
        String purchaseAmount = UserInput();
        return parseValidatedLottoCount(purchaseAmount);
    }
}
