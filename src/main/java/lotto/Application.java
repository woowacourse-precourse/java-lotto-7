package lotto;

import lotto.controller.LottoController;
import lotto.controller.ResultController;
import lotto.controller.WinningLottoController;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.service.WinningLottoService;

public class Application {
    public static void main(String[] args) {
        // 서비스와 컨트롤러 객체 생성
        LottoService lottoService = new LottoService();
        WinningLottoService winningLottoService = new WinningLottoService();
        ResultService resultService = new ResultService();

        // 컨트롤러 초기화
        WinningLottoController winningLottoController = new WinningLottoController(winningLottoService);
        ResultController resultController = new ResultController(resultService);

        // 메인 컨트롤러 초기화 및 실행
        LottoController lottoController = new LottoController(lottoService, winningLottoController, resultController);
        lottoController.run();
    }
}
