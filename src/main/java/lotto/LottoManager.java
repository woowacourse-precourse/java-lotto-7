package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final int LOTTO_PRICE = 1000;

    public void run() {
        int purchaseAmount = parsePurchaseAmount(Input.inputPurchaseAmount());
        List<Lotto> lottoes = purchaseLottoes(purchaseAmount);
        Output.printPurchaseMessage(lottoes.size());
        lottoes.forEach(Output::printLotto);
        List<Integer> winningNumber = parseWinningNumber(Input.inputWinningNumber());
    }

    private int parsePurchaseAmount(String inputPurchaseAmount) {
        return Integer.parseInt(inputPurchaseAmount);
    }

    private List<Integer> parseWinningNumber(String inputWinningNumber) {
        String[] winningNumbers = inputWinningNumber.split(WINNING_NUMBER_DELIMITER);
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<Lotto> purchaseLottoes(final int purchaseAmount) {
        int totalLottoCount = purchaseAmount / LOTTO_PRICE;
        return LottoMachine.issueLottoes(totalLottoCount);
    }
}
