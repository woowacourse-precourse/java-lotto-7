package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRound;
import lotto.model.Order;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    static final int ROUND_NUMBER = 1; // 로또 회차

    public static void run() {

        LottoRound lottoRound = initializeLottoRound();
        Order userOrder = createUserOrder(lottoRound);

        setupWinningNumbers(lottoRound);
        userOrder.calculateMatchCounts();

        printResults(userOrder);
    }

    private static LottoRound initializeLottoRound() {
        return new LottoRound(ROUND_NUMBER);
    }

    private static Order createUserOrder(LottoRound lottoRound) {
        int orderCount = inputOrderCount();
        Order order = new Order(lottoRound, orderCount);
        order.generateOrderedLotto(orderCount);
        return order;
    }

    private static void setupWinningNumbers(LottoRound lottoRound) {
        Lotto winningLotto = inputWinningLotto();
        lottoRound.setWinningLotto(winningLotto);
        int bonusNumber = inputBonusNumber(lottoRound);
        lottoRound.setBonusNumber(bonusNumber);
    }
    private static int inputOrderCount() {
        while(true){
            try {
                int orderCount = InputView.parseOrder(InputView.inputOrderPrice());
                System.out.println();
                OutputView.printOrderNumber(orderCount);
                return orderCount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto inputWinningLotto() {
        while (true) {
            try {
                Lotto winningLotto = new Lotto(InputView.parseWinningNumber(InputView.inputWinningNumber()));
                return winningLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int inputBonusNumber(LottoRound lottoRound) {
        while (true) {
            try {
                int bonusNumber = InputView.parseBonusNumber(InputView.inputBonusNumber(), lottoRound);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printResults(Order userOrder) {
        OutputView.printWinningAmount(userOrder.getMatchCounts());
        OutputView.printTotalProfit(userOrder);
    }
}
