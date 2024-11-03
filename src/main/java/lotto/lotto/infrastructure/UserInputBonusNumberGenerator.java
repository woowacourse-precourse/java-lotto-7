package lotto.lotto.infrastructure;

import lotto.lotto.domain.BonusNumber;
import lotto.lotto.service.BonusNumberCreatorService;
import lotto.lotto.domain.WinningLotto;
import lotto.lotto.validator.LottoValidator;
import lotto.view.input.hanlder.domain.InputHandlerService;
import lotto.view.output.infrastructure.ErrorOutput;

public class BonusNumberCreator implements BonusNumberCreatorService {
    private final InputHandlerService inputHandlerService;
    public BonusNumberCreator(InputHandlerService inputHandlerService) {
        this.inputHandlerService = inputHandlerService;
    }
    @Override
    public BonusNumber create(WinningLotto winningLotto) {
        try {
            BonusNumber bonusNumber = inputHandlerService.retrieveReceive(BonusNumber::of);
            LottoValidator.bonusNumberValidate(bonusNumber, winningLotto);
            return bonusNumber;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            ErrorOutput.view(illegalArgumentException);
            return create(winningLotto);
        }

    }
}
