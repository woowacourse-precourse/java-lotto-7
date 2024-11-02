package lotto.view;

import lotto.domain.PrintConstants;
import lotto.validator.InputValidator;

import java.util.List;

public class InputView {
    private InputValidator inputValidator;
    private PrintConstants printConstants;

    public InputView() {
        inputValidator = new InputValidator();
        printConstants = new PrintConstants();
    }


    public List<String> inputLottoPrice() {
        
    }

    public String inputLottoWinningNumbers() {
    }

    public String inputLottoBonusNumber() {
    }
}
