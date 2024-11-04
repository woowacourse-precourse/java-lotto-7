package lotto.service;

import java.util.List;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.controller.InputController;
import lotto.controller.OutputController;

public class LottoMachineService {
    private final InputController inputController = new InputController();
    private final OutputController outputController = new OutputController();
    private final LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();
    private final LottoCalculatorService lottoCalculatorService = new LottoCalculatorService();

    public LottoMachineService() {
    }

    public void run() {
        //1. 구매 정보 입력
        Integer purchaseNumber = inputController.getPurchaseNumber();

        //2. 구매 로또 생성 및 출력
        List<Lotto> userLottos = lottoGeneratorService.generateLottos(purchaseNumber);
        outputController.printUserLottos(purchaseNumber, userLottos);

        //3. 당첨 로또 입력
        Lotto winningLotto = inputController.getLotto();
        Integer bonusNumber = inputController.getBonusNumber(winningLotto);

        //4. 당첨 결과 계산 및 출력
        LottoResult lottoResult = lottoCalculatorService.getResult(userLottos, winningLotto, bonusNumber,
                purchaseNumber);
        outputController.printResult(lottoResult);
    }
}
