package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.RandomLottoNumberGenerator;
import lotto.validation.Validator;

public class Application {
    public static void main(String[] args) {

        Validator validator = new Validator();
        RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();
        LottoService lottoService = new LottoService(randomLottoNumberGenerator);

        LottoController lottoController = new LottoController(lottoService, validator);
        lottoController.run();
    }
}
