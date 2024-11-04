package lotto.view;

import java.util.EnumMap;
import lotto.domain.Customer;
import lotto.domain.Rank;

public class OutputView {

    private static final String LOTTOS_PURCHASED_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";

    public static void lottosPurchasedMessage(Customer customer) {
        System.out.println(String.format(LOTTOS_PURCHASED_MESSAGE, customer.getPrice().getCount()));
    }

    public static void lottosPurchased(Customer customer) {
        customer.getLottos()
                .getValues()
                .stream()
                .forEach(lotto -> System.out.println(lotto));
    }

    public static void resultMessage(EnumMap<Rank, Integer> rankMap) {
        System.out.print(RESULT_MESSAGE);
        rankMap.forEach((rank, matchCount) -> System.out.println(String.format(rank.getMessage(), matchCount)));
    }
}
