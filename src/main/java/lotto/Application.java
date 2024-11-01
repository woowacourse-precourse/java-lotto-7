package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Customer customer = new Customer();

        List<Lotto> lottos = customer.buy();

        WinningLotto winningLotto = customer.setWinningLotto();

        Map<Prize, Integer> result = customer.countPrize(lottos, winningLotto);

        customer.statistics(result);
    }
}
