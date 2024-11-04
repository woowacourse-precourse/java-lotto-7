package lotto.controller;

import lotto.util.InputParser;
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
}
