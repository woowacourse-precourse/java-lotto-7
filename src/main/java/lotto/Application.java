package lotto;

import java.util.List;
import java.util.Map;
import lotto.numberSelector.NumberSelector;
import lotto.numberSelector.RandomSelector;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Customer customer = new Customer();
        NumberSelector selector = new RandomSelector();

        List<Lotto> lottos = customer.buy(selector);

        WinningLotto winningLotto = customer.setWinningLotto();

        Map<Prize, Integer> result = customer.countPrize(lottos, winningLotto);

        customer.statistics(result);
    }
}
