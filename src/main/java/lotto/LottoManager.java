package lotto;

import static lotto.view.Input.inputBonusNumber;
import static lotto.view.Input.inputPurchaseAmount;
import static lotto.view.Input.inputWinningNumbers;
import static lotto.InputParser.parseInt;
import static lotto.InputParser.parseWinningNumbers;

import java.util.List;
import lotto.view.Output;

public class LottoManager {

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoes = purchaseLottoes(purchaseAmount);
        Output.printPurchaseMessage(lottoes.size());
        lottoes.forEach(Output::printLotto);
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);
        WinningRecord winningRecord = new WinningRecord();
        lottoes.stream()
                .map(lotto -> lotto.getRank(winningNumbers, bonusNumber))
                .forEach(winningRecord::put);
        Output.printWinningStatistics(winningRecord);
        int totalWinningAmount = winningRecord.calculateTotalWinningAmount();
        Output.printReturnRate(purchaseAmount.calculateReturnRate(totalWinningAmount));
    }

    private static PurchaseAmount getPurchaseAmount() {
        try {
            int purchaseAmount = parseInt(inputPurchaseAmount());
            return PurchaseAmount.of(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private static WinningNumbers getWinningNumbers() {
        try {
            List<Integer> winningNumbers = parseWinningNumbers(inputWinningNumbers());
            return WinningNumbers.of(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    private static BonusNumber getBonusNumber(final WinningNumbers winningNumbers) {
        try {
            int bonusNumber = parseInt(inputBonusNumber());
            winningNumbers.validateDuplicatedWithBonusNumber(bonusNumber);
            return BonusNumber.of(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private List<Lotto> purchaseLottoes(final PurchaseAmount purchaseAmount) {
        return LottoMachine.purchaseLottoes(purchaseAmount);
    }
}