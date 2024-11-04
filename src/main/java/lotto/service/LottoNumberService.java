package lotto.service;

import lotto.domain.number.Number;
import lotto.domain.number.NumberFactory;
import lotto.domain.number.Numbers;
import lotto.view.InputHandler;

public class LottoNumberService {
    private final InputHandler inputHandler;

    public LottoNumberService(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public Numbers createWinningNumbers(String inputWinningNumbers) {
        return inputHandler.splitLottoNumbers(inputWinningNumbers);
    }

    public Number createBonusNumber(String inputBonusNumber, Numbers winningNumbers) {
        int bonusNumber = inputHandler.stringToNumber(inputBonusNumber);
        return NumberFactory.createBonusNumber(bonusNumber, winningNumbers);
    }

}
