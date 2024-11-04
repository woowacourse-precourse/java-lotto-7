package lotto.controller;

import lotto.model.WinningLotto;
import lotto.service.WinningLottoService;
import lotto.util.Validator;
import lotto.view.InputView;

public class WinningLottoController {
    private final WinningLottoService winningLottoService;

    public WinningLottoController(WinningLottoService winningLottoService){
        this.winningLottoService = winningLottoService;
    }

    public WinningLotto getWinningLotto(){
        String winningNumbersInput = InputView.getWinningNumbers();
        int bonusNumber = Validator.parseInt(InputView.getBonusNumbers());

        return winningLottoService.create(winningNumbersInput, bonusNumber);
    }
}
