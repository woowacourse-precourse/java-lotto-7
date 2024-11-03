package lotto;

import lotto.handler.LottoCheckController;
import lotto.handler.LottoGenerateController;
import lotto.handler.LottoResultController;

public class LottoApp {

    private final LottoGenerateController generateController;
    private final LottoCheckController checkController;
    private final LottoResultController resultController;

    public LottoApp(LottoGenerateController generateController, LottoCheckController checkController,
        LottoResultController resultController) {
        this.generateController = generateController;
        this.checkController = checkController;
        this.resultController = resultController;
    }

    public void run() {
        generateController.purchaseAll();
    }
}
