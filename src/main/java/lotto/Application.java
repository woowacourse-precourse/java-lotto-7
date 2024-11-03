package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputLottoView;
import lotto.view.OutputLottoView;

public class Application {
    public static void main(String[] args) {
        InputLottoView inputLottoView = new InputLottoView();
        OutputLottoView outputLottoView = new OutputLottoView();
        LottoService lottoService=new LottoService(outputLottoView, inputLottoView);
        LottoController controller = new LottoController(inputLottoView,outputLottoView, lottoService);
        controller.startLotto();

    }
}
