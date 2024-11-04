package lotto.usecase;

import lotto.application.prize.controller.PrizeController;
import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.prize.service.PrizeResponse;

public class CreatePrizeUsecase {

    private final CreateWinnerNumbersUsecase createWinnerNumbersUsecase;
    private final CreateBonusNumberUsecase createBonusNumberUsecase;
    private final PrizeController prizeController;

    public CreatePrizeUsecase(CreateWinnerNumbersUsecase createWinnerNumbersUsecase,
                              CreateBonusNumberUsecase createBonusNumberUsecase,
                              PrizeController prizeController) {
        this.createWinnerNumbersUsecase = createWinnerNumbersUsecase;
        this.createBonusNumberUsecase = createBonusNumberUsecase;
        this.prizeController = prizeController;
    }

    public PrizeResponse execute() {
        WinnerNumbers winNums = createWinnerNumbersUsecase.execute();
        BonusNumber bonus = createBonusNumberUsecase.execute(winNums);

        Long createdId = prizeController.create(winNums.getLottoNumbers(), bonus.getValue());
        return prizeController.getPrize(createdId);
    }
}
