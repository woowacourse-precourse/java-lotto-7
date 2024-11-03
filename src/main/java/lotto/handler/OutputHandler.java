package lotto.handler;

import java.util.List;
import lotto.Lotto;

public class OutputHandler {

    public void printPurchasedLotto(final int ticket, final List<Lotto> purchasedLottos){

        System.out.println();
        System.out.println(ticket+"개를 구매했습니다");

        purchasedLottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }
}
