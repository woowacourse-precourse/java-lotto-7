package lotto;

import lotto.application.service.LottoMachine;
import lotto.application.service.LottoAnchor;
import lotto.application.service.LottoService;
import lotto.application.support.LottoInputParser;
import lotto.controller.LottoController;
import lotto.view.KeyboardLottoInputView;
import lotto.view.MonitorLottoOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController controller = new LottoController(
                keyboardLottoInputView(),
                monitorLottoOutputView(),
                lottoService(),
                lottoInputParser()
        );

        controller.run();
    }

    private static KeyboardLottoInputView keyboardLottoInputView(){
        return new KeyboardLottoInputView();
    }

    private static MonitorLottoOutputView monitorLottoOutputView(){
        return new MonitorLottoOutputView();
    }

    private static LottoInputParser lottoInputParser(){
        return new LottoInputParser();
    }

    private static LottoService lottoService(){
        return new LottoService(
                new LottoMachine(),
                new LottoAnchor()
        );
    }
}
