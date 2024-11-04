package lotto.view;

import lotto.domain.Customer;

public class OutputView {

    private static final String LOTTOS_PURCHASED_MESSAGE = "\n%d개를 구매했습니다.";

    public static void lottosPurchasedMessage(Customer customer) {
        System.out.println(String.format(LOTTOS_PURCHASED_MESSAGE, customer.getPrice().getCount()));
    }

    public static void lottosPurchased(Customer customer) {
        customer.getLottos()
                .getValues()
                .stream()
                .forEach(lotto -> System.out.println(lotto));
    }
}
