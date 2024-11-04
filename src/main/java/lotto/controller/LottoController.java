package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningState;
import lotto.util.InputParser;
import lotto.util.RandomNumbersGenerator;
import lotto.view.LottoView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private int purchasePrice;
    private int turn;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoController() {
        this.purchasePrice = InputParser.parsePurchasePrice(LottoView.inputPurchasePrice());
        this.turn = purchasePrice / 1000;
        this.winningNumbers = InputParser.parseWinningNumbers(LottoView.inputWinningNumbers());
        this.bonusNumber = InputParser.parseBonusNumber(LottoView.inputBonusNumber());
    }

    public void runLotto() {
        Lotto[] lottos = new Lotto[turn];
        Map<String, Integer> results = new HashMap<>();

        for (int i = 0; i < turn; i++) {
            lottos[i] = new Lotto(RandomNumbersGenerator.create());
            String result = lottos[i].checkWinner(winningNumbers, bonusNumber);

            int count = 0;
            if (results.containsKey(result)) {
                count = results.get(result);
            }
            results.put(result, count + WinningState.valueOf(result).getAmount());
        }
    }
}
