package lotto;

import handler.ConsoleHandler;
import java.util.List;

public class Application {

    private final Client client;

    public Application() {
        this.client = new Client();
    }

    public static void main(String[] args) {
        Application application = new Application();

        application.run();
    }

    private void run() {
        buyLotto();

    }

    private void buyLotto() {
        while (client.getLottos().isEmpty()) {
            try {
                int buyAmount = ConsoleHandler.inputIntValue("구입금액을 입력해 주세요.");
                LottoMachine lottoMachine = new LottoMachine();
                List<Lotto> lottos = lottoMachine.getLottos(buyAmount);
                client.addLotto(lottos);
            } catch (IllegalArgumentException exception) {
                ConsoleHandler.announceError(exception.getMessage());
            }
        }

        ConsoleHandler.announceBuyLottos(client.getLottos());
    }
}
