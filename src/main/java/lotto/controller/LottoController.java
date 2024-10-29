package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController() {
        this.inputView = new InputView();
    }

    public void run() {
        String inputPayment = inputView.readPayment();
        int payment = Integer.parseInt(inputPayment);

        String inputWinningNumbers = inputView.readWinningNumbers();
        String[] rawWinningNumbers = inputWinningNumbers.split(",");
        List<Integer> winningNumbers = Arrays.stream(rawWinningNumbers).map(Integer::parseInt).toList();

        String inputBonus = inputView.readBonus();
        int bonus = Integer.parseInt(inputBonus);
    }
}
