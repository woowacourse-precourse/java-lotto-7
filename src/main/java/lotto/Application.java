package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        OutputController outputController = new OutputController();
        InputController inputController = new InputController();

        int purchaseNumber = inputController.inputPurchaseNumber();
        List<Lotto> lottos = outputController.printLottos(purchaseNumber);

        List<Integer> winNumber = inputController.inputWinNumber();
        int bonusNumber = inputController.inputBonusNumber(winNumber);

        WinNumbers winNumbers = new WinNumbers(winNumber, bonusNumber);
        LottoResult lottoResult = outputController.printStatistics(lottos, winNumbers);
        outputController.printRateOfReturn(lottoResult,purchaseNumber);
    }
}
