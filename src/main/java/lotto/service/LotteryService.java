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

    public int getPurchaseAmount() {
        outputView.printRequirePurchaseAmount();

        final String inputPurchaseAmount = Console.readLine();
        final int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        lotteryValidator.validatePurchaseAmount(purchaseAmount);

        return purchaseAmount / 1000;
    }
}
