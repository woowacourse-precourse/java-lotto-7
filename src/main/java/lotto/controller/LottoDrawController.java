package lotto.controller;

import static lotto.util.enums.PrintMessage.ASK_BONUS_NUMBER_INPUT;
import static lotto.util.enums.PrintMessage.ASK_LOTTO_NUMBER_INPUT;

import lotto.view.InputView;

public class LottoDrawController {

    public void draw() {
        String lottoNumbers = InputView.getInput(ASK_LOTTO_NUMBER_INPUT.getMessage());
        String bonusNumber = InputView.getInput(ASK_BONUS_NUMBER_INPUT.getMessage());
    }
}
