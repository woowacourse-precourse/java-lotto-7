package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.LotteryValidator;
import lotto.view.OutputView;

public class LotteryService {
    private final OutputView outputView;
    private final LotteryValidator lotteryValidator;

    public LotteryService() {
        this.outputView = new OutputView();
        this.lotteryValidator = new LotteryValidator();
    }

    public int readPurchaseAmount() {
        outputView.printRequirePurchaseAmount();

        final String inputPurchaseAmount = Console.readLine();
        lotteryValidator.validatePurchaseAmount(Integer.parseInt(inputPurchaseAmount));

        return Integer.parseInt(inputPurchaseAmount);
    }
}
