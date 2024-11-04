package lotto;

import lottoController.GenerateLottoController;
import lottoController.LottoResultController;

public class Application {
    public static void main(String[] args) {
        GenerateLottoController generateLottoController = new GenerateLottoController();
        generateLottoController.generateLotto();

        LottoResultController resultController = new LottoResultController();
        resultController.showLottoResult();
    }
}
