package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        int money = consoleHandler.inputMoney();

        Customer customer = new Customer(money);

        LottoStore lottoStore = new LottoStore();
        customer.purchaseLottoFrom(lottoStore);

        List<Lotto> purchasedLotto = customer.getLottos();
        consoleHandler.printLottoCount(purchasedLotto.size());
        consoleHandler.printPurchasedLotto(purchasedLotto);
    }

}
