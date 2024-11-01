package lotto.core.controller;

import lotto.commons.logger.Logger;
import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.service.CreateLottoPurchaseAmountService;
import lotto.core.view.View;

public class InputLottoPurchaseAmountController implements Controller<Void, LottoPurchaseAmountDto> {

    private CreateLottoPurchaseAmountService service;

    private View<String> view;

    private LottoPurchaseAmountDto data;

    public InputLottoPurchaseAmountController(CreateLottoPurchaseAmountService service, View<String> view) {
        this.service = service;
        this.view = view;
        this.view.setContent("구입금액을 입력해 주세요.");
    }

    @Override
    public LottoPurchaseAmountDto request(Void unused) {
        while (true) {
            if (this.processRead()) break;
        }
        return this.data;
    }

    private boolean processRead() {
        try {
            view.display();
            this.data = this.service.create(this.read());
            return true;
        } catch (IllegalArgumentException e) {
            Logger.error(e);
            return false;
        }
    }

    public String read() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}
