package lotto;

import lotto.controller.LottoController;
import lotto.io.Input;
import lotto.io.Output;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.util.Validator;

public class Application {
    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input();
        Validator validator = new Validator();
        LottoService lottoService = new LottoServiceImpl();

        LottoController lottoController = new LottoController(output, input, validator, lottoService);
        lottoController.playLotto();
    }
}
