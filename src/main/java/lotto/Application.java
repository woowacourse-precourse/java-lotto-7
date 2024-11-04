package lotto;

import lotto.controller.LottoController;
import lotto.repository.PaperRepository;
import lotto.repository.PaperRepositoryImpl;
import lotto.service.PaperService;
import lotto.service.PaperServiceImpl;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        PaperRepository paperRepository = new PaperRepositoryImpl();
        PaperService paperService = new PaperServiceImpl(paperRepository);

        LottoController lottoController = new LottoController(view, paperService);

        lottoController.start();
    }
}
