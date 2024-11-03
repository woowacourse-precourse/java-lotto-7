package lotto.usecase;

import lotto.application.prize.controller.PrizeController;
import lotto.application.prize.service.PrizeResponse;
import lotto.application.prize.view.input.PrizeInputView;
import lotto.application.prize.view.input.PrizeViewRequest;

public class CreatePrizeUsecase {
    private final PrizeInputView inputView;
    private final PrizeController controller;

    public CreatePrizeUsecase(PrizeInputView inputView, PrizeController controller) {
        this.inputView = inputView;
        this.controller = controller;
    }

    public PrizeResponse execute() {
        PrizeViewRequest request = inputView.initialize();
        Long savedId = controller.save(request.winnerNumbers(), request.bonusNumber());

        return controller.getPrize(savedId);
    }

}
