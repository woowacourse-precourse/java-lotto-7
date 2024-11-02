package lotto;

import static lotto.IOProcessor.printIssueAmount;
import static lotto.IOProcessor.printIssuedLottos;
import static lotto.IOProcessor.printProfitRate;
import static lotto.IOProcessor.printWinningDetails;
import static lotto.IOProcessor.readBonusNumber;
import static lotto.IOProcessor.readPurchaseAmount;
import static lotto.IOProcessor.readWinningNumbers;
import static lotto.Lotto.getIssueAmount;
import static lotto.Lotto.issueLottos;

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
