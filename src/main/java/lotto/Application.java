package lotto;

import static lotto.IOProcessor.printIssueAmount;
import static lotto.IOProcessor.printIssuedLottos;
import static lotto.IOProcessor.printProfitRate;
import static lotto.IOProcessor.printWinningDetails;
import static lotto.Lotto.getIssueAmount;
import static lotto.Lotto.readBonusNumber;
import static lotto.Lotto.readPurchaseAmount;
import static lotto.Lotto.readWinningNumbers;
import static lotto.Utils.issueLottos;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = readPurchaseAmount();
        int issueAmount = getIssueAmount(purchaseAmount);

        List<Lotto> issuedLottos = issueLottos(issueAmount);
        printIssueAmount(issueAmount);
        printIssuedLottos(issuedLottos);

        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);

        for (Lotto lotto : issuedLottos) {
            lotto.checkLottoWin(winningNumbers, bonusNumber);
        }

        printWinningDetails();
        printProfitRate(purchaseAmount);
    }
}
