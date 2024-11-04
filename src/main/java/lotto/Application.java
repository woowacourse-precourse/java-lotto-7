package lotto;

import lotto.controller.LottoController;
import lotto.service.TicketGenerator;
import lotto.service.TicketRandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        TicketGenerator generator = new TicketRandomGenerator();

        LottoController controller = new LottoController(inputView, outputView, generator);

        controller.play();
    }
}
