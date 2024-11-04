package lotto;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchaser lottoPurchaser = Prompt.promptPurchaseAmount();
        List<Lotto> purchasedLottos = lottoPurchaser.purchaseLotto();
        printPurchasedLottos(purchasedLottos);
        Lotto winningLotto = Prompt.promptWinningLotto();
        BonusNumber bonusNumber = Prompt.promptBonusNumber();
    }

    private static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println("\n" + purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto purchasedLotto : purchasedLottos){
            List<Integer> numbers = purchasedLotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }
}
