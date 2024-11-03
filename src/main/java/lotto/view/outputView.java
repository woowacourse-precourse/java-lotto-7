package lotto.view;

import lotto.domain.LottoResult;
import lotto.dto.Bag;
import lotto.dto.Lotto;

import java.util.List;

public class outputView {
    public static void printPurchasedLottoTickets(Bag bag) {
        System.out.printf("%d개를 구매했습니다.\n",bag.getNumberOfLottoTickets());
        List<Lotto> purchasedLottoTickets = bag.getPurchasedLotto();
        purchasedLottoTickets.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printLottoResult(LottoResult lottoResult) {
    }
}
