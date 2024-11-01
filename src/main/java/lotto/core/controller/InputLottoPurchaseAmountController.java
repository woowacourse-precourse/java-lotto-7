package lotto.core.controller;

import lotto.commons.logger.Logger;
import lotto.core.model.LottoPurchaseAmount;
import lotto.core.view.View;

public class InputLottoPurchaseAmountController implements RequestController<LottoPurchaseAmount> {

    private LottoPurchaseAmount amount;

    private View view;

    public InputLottoPurchaseAmountController(View view) {
        this.view = view;
    }

    @Override
    public LottoPurchaseAmount getResponse() {
        if (this.amount == null) {
            this.process();
        }
        return this.amount;
    }

    @Override
    public void process() {
        while (true) {
            if (this.processRead()) break;
        }
    }

    private boolean processRead() {
        try {
            view.display("구입금액을 입력해 주세요.");
            this.amount = new LottoPurchaseAmount(this.request());
            return true;
        } catch (IllegalArgumentException e) {
            Logger.error(e);
            return false;
        }
    }

    @Override
    public String request() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}
