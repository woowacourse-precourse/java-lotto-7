package lotto.lotto.domain.winning.infrastructure;

import lotto.lotto.domain.winning.domain.BonusNumber;
import lotto.lotto.domain.winning.domain.WinningLotto;
import lotto.lotto.validator.LottoValidator;
import lotto.view.input.hanlder.domain.InputHandlerService;
import lotto.view.output.infra.ErrorOutput;

public class BonusNumberCreator {
    private final InputHandlerService inputHandlerService;
    public BonusNumberCreator(InputHandlerService inputHandlerService) {
        this.inputHandlerService = inputHandlerService;
    }
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
