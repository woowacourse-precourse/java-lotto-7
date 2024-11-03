package lotto.lotto.infrastructure;

import lotto.lotto.domain.BonusNumber;
import lotto.lotto.service.BonusNumberGenerator;
import lotto.lotto.domain.WinningLotto;
import lotto.lotto.validator.LottoValidator;
import lotto.view.input.hanlder.domain.InputHandlerService;
import lotto.view.output.infrastructure.ErrorOutput;

public class UserInputBonusNumberGenerator implements BonusNumberGenerator {
    private final InputHandlerService inputHandlerService;
    public UserInputBonusNumberGenerator(InputHandlerService inputHandlerService) {
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
