package lotto.presentation.controller;

import static lotto.presentation.view.InputForm.Header.BONUS_NUMBER;

import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.Winning;
import lotto.domain.winning.WinningNumbers;
import lotto.presentation.controller.common.LottoController;
import lotto.presentation.model.Key;
import lotto.presentation.model.Model;
import lotto.presentation.view.InputForm;
import lotto.service.winning.WinningService;

public class BonusNumberController extends LottoController {

    private final WinningService winningService;

    public BonusNumberController(WinningService winningService) {
        this.winningService = winningService;
    }

    @Override
    protected void request(Model model) {
        String input = InputForm.read(BONUS_NUMBER);
        model.put(Key.BONUS_NUMBER, input);
    }

    @Override
    protected void handle(Model model) {
        String input = (String) model.get(Key.BONUS_NUMBER);
        int number = Integer.parseInt(input);

        BonusNumber bonusNumber = new BonusNumber(number);
        model.put(Key.BONUS_NUMBER, bonusNumber);

        WinningNumbers winningNumbers = (WinningNumbers) model.get(Key.WINNING_NUMBERS);
        Winning winning = winningService.createWinning(winningNumbers, bonusNumber);
        model.put(Key.WINNING, winning);
    }

    @Override
    protected void response(Model model) {
        //do Nothing
    }
}
