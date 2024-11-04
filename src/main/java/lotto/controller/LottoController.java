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
    private Map<String, Integer> results;

    public LottoController() {
        this.purchasePrice = InputParser.parsePurchasePrice(LottoView.inputPurchasePrice());
        this.turn = purchasePrice / 1000;
        this.winningNumbers = InputParser.parseWinningNumbers(LottoView.inputWinningNumbers());
        this.bonusNumber = InputParser.parseBonusNumber(LottoView.inputBonusNumber());
        results = new HashMap<>();
        for (WinningState state : WinningState.values()) {
            results.put(state.name(), 0);
        }
    }

    public void runLotto() {
        LottoView.printTurn(turn);
        Lotto[] lottos = new Lotto[turn];

        for (int i = 0; i < turn; i++) {
            lottos[i] = new Lotto(RandomNumbersGenerator.create());
            LottoView.printLotto(lottos[i].toString());
            String result = lottos[i].checkWinner(winningNumbers, bonusNumber);
            int count = results.get(result);
            results.put(result, ++count);
        }
        LottoView.printResult(results);
    }
}
