package lotto.usecase.nneew.bonus;

import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.WinnerNumbers;

public class BonusController {

    private final CreateBonusNumberService service;

    public BonusController(CreateBonusNumberService service) {
        this.service = service;
    }

    public BonusNumber create(WinnerNumbers winNums, int bonus) {
        return service.execute(winNums, bonus);
    }
}

