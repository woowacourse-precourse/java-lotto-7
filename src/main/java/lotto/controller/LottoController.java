package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import lotto.model.BonusBall;
import lotto.model.LottoSellingMachine;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningBalls;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.SimpleInputValidator;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView(new SimpleInputValidator());
        this.outputView = new OutputView();
    }

    public void play() {
        Lottos lottos = sellLoto();
        WinningBalls winningBalls = choiceWinningNumber();
        BonusBall bonusBall = choiceBonusNumber(winningBalls);
        printResult(lottos, winningBalls, bonusBall);
    }

    private Lottos sellLoto() {
        while (true) {
            try {
                Long money = inputView.inputAmount();
                Lottos lottos = LottoSellingMachine.sell(money);
                outputView.printSellResult(lottos);
                return lottos;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private WinningBalls choiceWinningNumber() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.inputWinningNumber();
                return new WinningBalls(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusBall choiceBonusNumber(WinningBalls winningBalls) {
        while (true) {
            try {
                int bonusNumber = inputView.inputBonuseNumber();
                return BonusBall.of(bonusNumber, winningBalls);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printResult(Lottos lottos, WinningBalls winningBalls, BonusBall bonusBall) {
        EnumMap<Rank, Integer> rankIntegerEnumMap = lottos.calculateWinningResults(winningBalls, bonusBall);
        Float returnRate1 = lottos.calculateReturnRate(winningBalls, bonusBall);

        outputView.printResult(rankIntegerEnumMap);
        outputView.printReturnRate(returnRate1);
    }
}
