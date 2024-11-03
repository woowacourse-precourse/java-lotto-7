package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.message.SystemMessage;

public class LottoMachine {
    private final InputView inputView = new InputView();
    private final Validator validator = new Validator();
    private final OutputView outputView = new OutputView();

    public List<Lotto> getLotteries() {
        String input = "";
        do {
            input = inputView.input(SystemMessage.INPUT_PURCHASE_MONEY_AMOUNT.getMessage());
        } while (!validateMoneyAmount(input));

        int moneyAmount = Integer.parseInt(input);
        return IntStream.range(0, calculateNumberLotto(moneyAmount))
                .mapToObj(num -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();
    }

    public int calculateNumberLotto(int moneyAmount) {
        return moneyAmount / 1000;
    }

    public boolean validateMoneyAmount(String moneyAmount) {
        try {
            validator.isNotNull(moneyAmount);
            validator.isNumber(moneyAmount);
            int number = Integer.parseInt(moneyAmount);
            validator.isOverMinimumPurchaseAmount(number);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return false;
        }
        return true;
    }
}
