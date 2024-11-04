package lotto;

import lotto.controller.LottoController;
import lotto.repository.paper.PaperRepository;
import lotto.repository.paper.PaperRepositoryImpl;
import lotto.repository.winning.WinningRepository;
import lotto.repository.winning.WinningRepositoryImpl;
import lotto.service.paper.PaperService;
import lotto.service.paper.PaperServiceImpl;
import lotto.service.winning.WinningService;
import lotto.service.winning.WinningServiceImpl;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        PaperRepository paperRepository = new PaperRepositoryImpl();
        PaperService paperService = new PaperServiceImpl(paperRepository);
        
        WinningRepository winningRepository = new WinningRepositoryImpl();
        WinningService winningService = new WinningServiceImpl(winningRepository);
        LottoController lottoController = new LottoController(view, paperService, winningService);

        lottoController.start();
    }
}
