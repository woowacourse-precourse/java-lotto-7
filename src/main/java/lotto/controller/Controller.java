package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private static final String SPLIT_DELIMITER = ", ";


    

    private LottoNumber requestBonusNumber() {
        try {
            return new LottoNumber(InputView.requestBonusNumber());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return requestBonusNumber();
        }
    }
}
