package lotto.controller;

import java.util.List;
import lotto.model.domain.BonusBall;
import lotto.model.domain.WinningBalls;
import lotto.model.service.LottoSellingMachine;
import lotto.model.service.Lottos;
import lotto.model.service.RankResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
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

                Lottos lottos = new LottoSellingMachine().sell(money);

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
        RankResult rankResult = lottos.calculateWinningResults(winningBalls, bonusBall);
        Long totalPrice = lottos.getTotalPrice();
        Float returnRate = rankResult.calculateReturnRate(totalPrice);

        outputView.printResult(rankResult);
        outputView.printReturnRate(returnRate);
    }
}
