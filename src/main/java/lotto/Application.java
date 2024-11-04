package lotto;

import lottoController.GenerateLottoController;
import lottoController.LottoResultController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GenerateLottoController generateLottoController = new GenerateLottoController();
        generateLottoController.generateLotto();

        LottoResultController resultController = new LottoResultController();
        resultController.showLottoResult();
    }
}
