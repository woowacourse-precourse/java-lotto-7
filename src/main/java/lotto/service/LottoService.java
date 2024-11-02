package lotto.service;

import lotto.validator.BonusNumValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.WinningNumValidator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final InputView inputView;

    public LottoService(InputView inputView) {
        this.inputView = inputView;
    }


}
