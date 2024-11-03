package lotto.usecase;

import lotto.controller.PrizeController;
import lotto.service.prize.PrizeResponse;
import lotto.view.input.PrizeInputView;
import lotto.view.input.PrizeViewRequest;

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
