package lotto.presentation.controller;

import static lotto.presentation.view.InputForm.Header.WINNING_NUMBERS;

import java.util.Arrays;
import java.util.List;
import lotto.domain.winning.WinningNumbers;
import lotto.presentation.controller.common.LottoController;
import lotto.presentation.model.Key;
import lotto.presentation.model.Model;
import lotto.presentation.view.InputForm;

public class WinningNumbersController extends LottoController {

    @Override
    protected void request(Model model) {
        String input = InputForm.read(WINNING_NUMBERS);
        model.put(Key.WINNING_NUMBERS, input);
    }

    @Override
    protected void handle(Model model) {
        String input = (String) model.get(Key.WINNING_NUMBERS);
        String[] numbers = input.trim().split(",");

        List<Integer> parsedNumbers = Arrays.stream(numbers)
            .map(Integer::parseInt)
            .toList();
        WinningNumbers winningNumbers = new WinningNumbers(parsedNumbers);

        model.put(Key.WINNING_NUMBERS, winningNumbers);
    }

    @Override
    protected void response(Model model) {
        //do Nothing
    }
}
