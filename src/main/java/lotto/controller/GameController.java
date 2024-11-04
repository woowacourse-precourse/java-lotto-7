package lotto.controller;

import lotto.MatchCalculator;
import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

public class GameController {
    public void run() {
        Input input = new Input();
        Output output = new Output();

        Purchase purchase = input.getPurchaseAmountInput();
        output.printPurchaseCount(purchase.getLottoTickets().size());
        output.printLottoTickets(purchase.getLottoTickets());
        Winning winning = input.getWinningNumberInput();
        Bonus bonus = input.getBonusNumberInput();

        MatchCalculator matchCalculator = new MatchCalculator(purchase.getLottoTickets(), winning.getNumbers(), bonus.getNumber());
        Result result = new Result();
        matchCalculator.calculateAllTickets(result);
        Profit profit = new Profit(result.getTotalProfit(),purchase.getPurchaseAmount());

        output.printResult(result.getMatchCount3(), result.getMatchCount4(),
                result.getMatchCount5(), result.getMatchCount5Bonus(),
                result.getMatchCount6(), profit.getRate());
    }
}
