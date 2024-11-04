package lotto;

import lotto.controller.GameController;
import lotto.service.GameService;
import lotto.util.LottoGenerator;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        GameService service = new GameService(lottoGenerator);
        GameController controller = new GameController(service);
        controller.run();
    }
}
