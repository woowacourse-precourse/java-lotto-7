package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRound;
import lotto.model.Order;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void run() {

        LottoRound lottoRound = initializeLottoRound();
        Order userOrder = createUserOrder(lottoRound);

        setupWinningNumbers(lottoRound);
        userOrder.calculateMatchCounts();

        printResults(userOrder);
    }

    private static LottoRound initializeLottoRound() {
        final int roundNumber = 1; // 로또 회차
        return new LottoRound(roundNumber);
    }

    private static Order createUserOrder(LottoRound lottoRound) {
        int orderCount = inputOrderCount();
        return new Order(lottoRound, orderCount);
    }

    private static void setupWinningNumbers(LottoRound lottoRound) {
        Lotto winningLotto = inputWinningLotto();
        lottoRound.setWinningLotto(winningLotto);
        int bonusNumber = inputBonusNumber();
        lottoRound.setBonusNumber(bonusNumber);
    }
    private static int inputOrderCount() {
        int orderCount = InputView.parseOrder(InputView.inputOrderPrice());
        OutputView.printOrderNumber(orderCount);
        return orderCount;
    }

    private static Lotto inputWinningLotto() {
        return new Lotto(InputView.parseWinningNumber(InputView.inputWinningNumber()));
    }

    private static int inputBonusNumber() {
        return InputView.parseBonusNumber(InputView.inputBonusNumber());
    }

    private static void printResults(Order userOrder) {
        OutputView.printWinningAmount(userOrder.getMatchCounts());
        OutputView.printTotalProfit(userOrder);
    }
}
