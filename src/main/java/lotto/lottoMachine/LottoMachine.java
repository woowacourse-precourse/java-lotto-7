package lotto.lottoMachine;

import java.util.List;
import lotto.controller.InputController;
import lotto.controller.OutputController;

public class LottoMachine {
    private final InputController inputController = new InputController();
    private final OutputController outputController = new OutputController();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final LottoCalculator lottoCalculator = new LottoCalculator();

    public LottoMachine() { }

    public void run() {
        //1. 구매 정보 입력
        Integer purchaseNumber = inputController.getPurchaseNumber();

        //2. 구매 로또 생성 및 출력
        List<Lotto> userLottos = lottoGenerator.generateLottos(purchaseNumber);
        outputController.printUserLottos(purchaseNumber, userLottos);

        //3. 당첨 로또 입력
        Lotto winningLotto = inputController.getLotto();
        Integer bonusNumber = inputController.getBonusNumber(winningLotto);

        //4. 당첨 결과 계산 및 출력
        LottoResult lottoResult = lottoCalculator.getResult(userLottos, winningLotto, bonusNumber, purchaseNumber);
        outputController.printResult(lottoResult);
    }
}
