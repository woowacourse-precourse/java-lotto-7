package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.util.random.LottoRandomUtil;

public class Application {
    public static void main(String[] args) {
        LottoRandomUtil lottoRandomUtil = LottoRandomUtil.getLottoRandomUtil();
        LottoService lottoService = new LottoService(lottoRandomUtil);
        LottoController lottoController = new LottoController(lottoService);

        lottoController.run();
    }
}
