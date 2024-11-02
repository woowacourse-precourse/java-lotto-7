package lotto;

public class Application {

    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        int money = consoleHandler.inputMoney();

        Customer customer = new Customer(money);

        LottoStore lottoStore = new LottoStore();
        customer.buyLottoFrom(lottoStore);
        List<Lotto> purchasedLotto = customer.getLottos();
    }

}
