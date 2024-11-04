package lotto;

import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView consoleView = ConsoleView.getInstance();
        LottoRepository lottoRepository = new LottoRepository();
        LottoService lottoService = new LottoService(lottoRepository);
        LottoController lottoController = new LottoController(consoleView, lottoService);

        lottoController.run();

    }
}
