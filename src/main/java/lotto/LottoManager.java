package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final int LOTTO_PRICE = 1000;

    public void run() {
        int purchaseAmount = parsePurchaseAmount(inputPurchaseAmount());
        List<Lotto> lottoes = purchaseLottoes(purchaseAmount);
        Output.printPurchaseMessage(lottoes.size());
        lottoes.forEach(Output::printLotto);
        List<Integer> winningNumber = parseWinningNumber(inputWinningNumber());
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

    private String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return input();
    }

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return input();
    }

    private static String input() {
        return Console.readLine();
    }

    private List<Lotto> purchaseLottoes(final int purchaseAmount) {
        int totalLottoCount = purchaseAmount / LOTTO_PRICE;
        return LottoMachine.issueLottoes(totalLottoCount);
    }
}
