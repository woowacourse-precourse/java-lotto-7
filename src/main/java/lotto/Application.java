package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        runLottoApplication();
    }

    private static void runLottoApplication() {
        try {
            int purchaseAmount = inputPurchaseAmount();
            int lottoCount = purchaseAmount / LOTTO_PRICE;
            List<Lotto> purchasedLottos = generateLottos(lottoCount);
            printPurchasedLottos(purchasedLottos);

            List<Integer> winningNumbers = inputWinningNumbers();
            int bonusNumber = inputBonusNumber();

            LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber, purchaseAmount);
            lottoResult.calculateResults(purchasedLottos);
            lottoResult.printResults();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine().trim());
                if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            }
        }
    }

    private static List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine().trim();
                String[] numbers = input.split(",");
                List<Integer> winningNumbers = new ArrayList<>();
                for (String number : numbers) {
                    winningNumbers.add(Integer.parseInt(number.trim()));
                }
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            }
        }
    }

    private static int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                return Integer.parseInt(Console.readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            }
        }
    }
}