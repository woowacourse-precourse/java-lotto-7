package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoService;
import lotto.model.util.LottoRandomUtil;

public class Application {
    public static void main(String[] args) {
        LottoRandomUtil lottoRandomUtil = LottoRandomUtil.getLottoRandomUtil();
        LottoService lottoService = new LottoService(lottoRandomUtil);
        LottoController lottoController = new LottoController(lottoService);

        lottoController.run();
    }
}
