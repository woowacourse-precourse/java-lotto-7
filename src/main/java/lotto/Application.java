package lotto;

import lotto.controller.ApplicationController;
import lotto.model.LottoGenerator;
import lotto.model.RankCalculator;
import lotto.model.WinningNumberGenerator;
import lotto.service.TicketService;
import lotto.util.ControllerFactory;
import lotto.util.IoComponent;
import lotto.util.LottoComponent;
import lotto.util.common.CommonIo;

public class Application {
    public static void main(String[] args) {
        CommonIo commonIo = new CommonIo();
        IoComponent ioComponent = new IoComponent(commonIo);
        LottoComponent lottoComponent = new LottoComponent(
                new TicketService(),
                new LottoGenerator(),
                new RankCalculator(),
                new WinningNumberGenerator()
        );
        ControllerFactory controllerFactory = new ControllerFactory(ioComponent, lottoComponent);
        ApplicationController applicationController = new ApplicationController(controllerFactory, ioComponent, lottoComponent);

        applicationController.runApplication();
    }
}
