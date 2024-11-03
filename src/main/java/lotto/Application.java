package lotto;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int purchaseAmount = ConsoleInput.getPurchaseAmount(scanner);
            LottoStore lottoStore = new LottoStore(purchaseAmount);
            List<Lotto> purchasedLottos = lottoStore.getLottos();
            ConsoleOutput.printPurchasedLottos(purchasedLottos);

            List<Integer> winningNumbers = ConsoleInput.getWinningNumbers(scanner);
            int bonusNumber = ConsoleInput.getBonusNumber(scanner);

            LottoResult result = new LottoResult(purchasedLottos, winningNumbers, bonusNumber);
            ConsoleOutput.printResults(result);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
