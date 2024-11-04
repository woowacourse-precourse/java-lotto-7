package lotto.controller;

import lotto.util.InputParser;
import lotto.util.RandomNumbersGenerator;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {
    private int purchasePrice;
    private int turn;
    private List<Integer> winningNumbers;

    public LottoController() {
        this.purchasePrice = InputParser.parsePurchasePrice(LottoView.inputPurchasePrice());
        this.turn = purchasePrice / 1000;
        this.winningNumbers = InputParser.parseWinningNumbers(LottoView.inputWinningNumbers());
    }

    public void runLotto() {
        List<Integer>[] numbers = new List[turn];
        for (int i = 0; i < turn; i++) {
            numbers[i] = RandomNumbersGenerator.create();
        }
    }
}
