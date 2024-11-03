package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class OutputView {

    public static void printLottoQuantity(Money money){
        System.out.printf("%d개를 구매했습니다.\n", money.getLottoQuantity());
    }

    public static void printPurchaseLotto(LotteryMachine lotteryMachine, Money money) {
        List<Lotto> lottoByPayment = lotteryMachine.createLottoByPayment(money);
        List<List<Integer>> purchaseLotto = lottoByPayment.stream()
                .map(Lotto::getNumbers).toList();
        for(List<Integer> lotto : purchaseLotto){
            Collections.sort(lotto);
            System.out.println(lotto);
        }
    }

}
