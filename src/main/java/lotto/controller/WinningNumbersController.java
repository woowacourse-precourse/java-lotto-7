package lotto.controller;

import java.util.Optional;
import java.util.function.Function;
import lotto.config.ErrorMessage;
import lotto.model.Lotto;
import lotto.model.win.WinningNumbers;
import lotto.service.LottoService;
import lotto.service.ValidationService;
import lotto.view.BonusNumberInputView;
import lotto.view.View;

public class WinningNumbersController implements Function<Lotto, WinningNumbers> {

    private final LottoService lottoService;
    private final ValidationService validator;
    public WinningNumbersController() {
        this.lottoService = new LottoService();
        this.validator = new ValidationService();
    }

    @Override
    public WinningNumbers apply(Lotto lotto) {
        try {
            View bonusView = new BonusNumberInputView();
            Optional<String> optionalBonus = bonusView.render();
            optionalBonus.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.STOP));

            int bonusNumber = validator.isNumber(optionalBonus.get());
            return lottoService.createWinningNumbers(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            View.of(e.getMessage(), true);
            return apply(lotto);
        }
    }
}
