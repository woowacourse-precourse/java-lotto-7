package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        PrintController printController = new PrintController();
        int purchaseNumber = printController.inputPurchaseNumber();
        List<Lotto> lottos = printController.printLottos(purchaseNumber);
        List<Integer> winNumber = printController.inputWinNumber();
        int bonusNumber = printController.inputBonusNumber(winNumber);
        WinNumbers winNumbers = new WinNumbers(winNumber, bonusNumber);
        LottoResult lottoResult = printController.printStatistics(lottos, winNumbers);
        printController.printRateOfReturn(lottoResult,purchaseNumber);
    }
}
