package lotto;

import static lotto.Input.inputPurchaseAmount;
import static lotto.Input.inputWinningNumber;
import static lotto.InputParser.parseInt;
import static lotto.InputParser.parseWinningNumber;

import java.util.List;

public class LottoManager {
    private static final int LOTTO_PRICE = 1000;

    public void run() {
        int purchaseAmount = parseInt(inputPurchaseAmount());
        List<Lotto> lottoes = purchaseLottoes(purchaseAmount);
        Output.printPurchaseMessage(lottoes.size());
        lottoes.forEach(Output::printLotto);
        List<Integer> winningNumber = parseWinningNumber(inputWinningNumber());
    }

    private List<Lotto> purchaseLottoes(final int purchaseAmount) {
        int totalLottoCount = purchaseAmount / LOTTO_PRICE;
        return LottoMachine.issueLottoes(totalLottoCount);
    }
}
