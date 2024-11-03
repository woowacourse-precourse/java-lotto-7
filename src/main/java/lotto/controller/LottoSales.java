package lotto.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.utils.Parser.parsePurchaseAmount;
import static lotto.view.InputView.askPurchaseAmount;
import static lotto.view.OutputView.printPurchasedLottos;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Deposit;
import lotto.model.Lotto;

public class LottoSales {
    public static Deposit makeDeposit() {
        while (true) {
            try {
                int purchaseAmount = parsePurchaseAmount(askPurchaseAmount());
                return new Deposit(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Lotto> issueLottoes(int numberOfLottoes) {
        List<Lotto> lottoes = IntStream.range(0, numberOfLottoes)
                .mapToObj(i -> new Lotto(pickUniqueNumbersInRange(1, 45, 6))).toList();
        printPurchasedLottos(lottoes);
        return lottoes;
    }
}
