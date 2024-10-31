package lotto.view;

import lotto.Bag;
import lotto.Lotto;

import java.util.List;

public class outputView {
    public static void printPurchasedLottoTickets(Bag bag) {
        System.out.printf("%d개를 구매했습니다.\n",bag.getNumberOfLottoTickets());
        List<Lotto> purchasedLottoTickets = bag.getPurchasedLotto();
        purchasedLottoTickets.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
