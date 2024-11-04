package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        PrintController printController = new PrintController();
        InputController inputController = new InputController();

        int purchaseNumber = inputController.inputPurchaseNumber();
        List<Lotto> lottos = printController.printLottos(purchaseNumber);

        List<Integer> winNumber = inputController.inputWinNumber();
        int bonusNumber = inputController.inputBonusNumber(winNumber);

        WinNumbers winNumbers = new WinNumbers(winNumber, bonusNumber);
        LottoResult lottoResult = printController.printStatistics(lottos, winNumbers);
        printController.printRateOfReturn(lottoResult,purchaseNumber);
    }
}
