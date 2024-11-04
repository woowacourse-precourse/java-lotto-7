package lotto;

import static lotto.view.InputParser.parseBonusNumber;
import static lotto.view.InputParser.parsePurchaseAmount;
import static lotto.view.Input.inputBonusNumber;
import static lotto.view.Input.inputPurchaseAmount;
import static lotto.view.Input.inputWinningNumbers;
import static lotto.view.InputParser.parseWinningNumbers;
import static lotto.view.Output.printErrorMessage;
import static lotto.view.Output.printPurchaseMessage;
import static lotto.view.Output.printReturnRate;
import static lotto.view.Output.printWinningStatistics;

import java.util.List;
import lotto.view.Output;

public class LottoManager {

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoes = purchaseLottoes(purchaseAmount);
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);
        WinningRecord winningRecord = getWinningRecord(lottoes, winningNumbers, bonusNumber);
        printResult(purchaseAmount, winningRecord);
    }

    private static PurchaseAmount getPurchaseAmount() {
        try {
            int purchaseAmount = parsePurchaseAmount(inputPurchaseAmount());
            return PurchaseAmount.of(purchaseAmount);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private static WinningNumbers getWinningNumbers() {
        try {
            List<Integer> winningNumbers = parseWinningNumbers(inputWinningNumbers());
            return WinningNumbers.of(winningNumbers);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    private static BonusNumber getBonusNumber(final WinningNumbers winningNumbers) {
        try {
            int bonusNumber = parseBonusNumber(inputBonusNumber());
            winningNumbers.validateDuplicatedWithBonusNumber(bonusNumber);
            return BonusNumber.of(bonusNumber);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private List<Lotto> purchaseLottoes(final PurchaseAmount purchaseAmount) {
        List<Lotto> lottoes = LottoMachine.purchaseLottoes(purchaseAmount);
        printPurchaseMessage(lottoes.size());
        lottoes.forEach(Output::printLotto);
        return lottoes;
    }

    private WinningRecord getWinningRecord(final List<Lotto> lottoes, final WinningNumbers winningNumbers,
                                           final BonusNumber bonusNumber) {
        WinningRecord winningRecord = new WinningRecord();
        lottoes.stream()
                .map(lotto -> lotto.getRank(winningNumbers, bonusNumber))
                .forEach(winningRecord::put);
        return winningRecord;
    }

    private static void printResult(final PurchaseAmount purchaseAmount, final WinningRecord winningRecord) {
        printWinningStatistics(winningRecord);
        int totalWinningAmount = winningRecord.calculateTotalWinningAmount();
        printReturnRate(purchaseAmount.calculateReturnRate(totalWinningAmount));
    }
}