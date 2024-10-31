package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

public class LotteryService {
    private final OutputView outputView;

    public LotteryService() {
        this.outputView = new OutputView();
    }

    public int readPurchaseAmount() {
        outputView.printRequirePurchaseAmount();
        return Integer.parseInt(Console.readLine());
    }
}
