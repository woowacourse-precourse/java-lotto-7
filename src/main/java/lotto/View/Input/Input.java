package lotto.View.Input;

import lotto.Validator.InputValidator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Input {
    private final InputValidator inputValidator;

    public Input(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int inputCash() {
        String cashInput = readLine();
        int cash = inputValidator.validateCashByInput(cashInput);
        return cash;
    }

    public List<Integer> inputLottoNum() {
        String lottoByUser = readLine();
        return inputValidator.validateLottNumByUser(lottoByUser);
    }

    public int inputBonusNum(){
        String bonusNum = readLine();
        return inputValidator.validateBonusNumByUser(bonusNum);
    }
}
