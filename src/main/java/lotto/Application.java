package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Application {
    private static final int PER_LOTTO_PRICE = 1000;
    private static final int RAND_MIN = 1;
    private static final int RAND_MAX = 45;
    private static final int THRESHOLD = 6;
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        int purchasePrice = getValidPurchasePrice();
        System.out.println();

        int lottoPieces = purchasePrice / PER_LOTTO_PRICE;
        LottoGame lottoGame = new LottoGame();

        generateLottos(lottoPieces, lottoGame);
        System.out.println();

        Lotto winningLotto = new Lotto(getWinningNumbers());
        System.out.println();
        int bonusNumber = getBonusNumber();
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");

        lottoGame.evaluateResults(winningLotto, bonusNumber);
        printResults(lottoGame.getTotalMatchCount());
        printWinningRate(lottoGame.getTotalMatchCount(), purchasePrice);
    }

    private static int getValidPurchasePrice() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String purchasePriceStr = Console.readLine();
                return validatePurchasePrice(purchasePriceStr);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static int validatePurchasePrice(String purchasePriceStr) {
        try {
            int purchasePrice = Integer.parseInt(purchasePriceStr);
            if (purchasePrice <= 0 || purchasePrice % PER_LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위의 올바른 금액을 입력하세요.");
            }
            return purchasePrice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식의 올바른 금액을 입력하세요.");
        }
    }

    private static void generateLottos(int lottoPieces, LottoGame lottoGame) {
        System.out.printf("%d개를 구매했습니다.%n", lottoPieces);
        for (int i = 0; i < lottoPieces; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(RAND_MIN, RAND_MAX, THRESHOLD));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoGame.purchaseLotto(lotto);
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] input = Console.readLine().split(DELIMITER);
                return parseWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String[] input) {
        if (input.length != THRESHOLD) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : input) {
            int num = Integer.parseInt(number.trim());
            validateWinningNumber(num);
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    private static void validateWinningNumber(int number) {
        if (number < RAND_MIN || number > RAND_MAX) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static int getBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                validateWinningNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printResults(Map<LottoResult, Integer> totalMatchCount) {
        System.out.printf("%d개 일치 (%,d원) - %d개%n", LottoResult.FIFTH.getMatchCount(), LottoResult.FIFTH.getPrize(), totalMatchCount.getOrDefault(LottoResult.FIFTH, 0));
        System.out.printf("%d개 일치 (%,d원) - %d개%n", LottoResult.FOURTH.getMatchCount(), LottoResult.FOURTH.getPrize(), totalMatchCount.getOrDefault(LottoResult.FOURTH, 0));
        System.out.printf("%d개 일치 (%,d원) - %d개%n", LottoResult.THIRD.getMatchCount(), LottoResult.THIRD.getPrize(), totalMatchCount.getOrDefault(LottoResult.THIRD, 0));
        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", LottoResult.SECOND.getMatchCount(), LottoResult.SECOND.getPrize(), totalMatchCount.getOrDefault(LottoResult.SECOND, 0));
        System.out.printf("%d개 일치 (%,d원) - %d개%n", LottoResult.FIRST.getMatchCount(), LottoResult.FIRST.getPrize(), totalMatchCount.getOrDefault(LottoResult.FIRST, 0));
    }

    private static long calculateTotalWinningAmount(Map<LottoResult, Integer> totalMatchCount) {
        return Arrays.stream(LottoResult.values())
                .mapToLong(result -> result.getPrize() * totalMatchCount.getOrDefault(result, 0))
                .sum();
    }

    private static void printWinningRate(Map<LottoResult, Integer> totalMatchCount, int purchasePrice) {
        long totalWinningAmount = calculateTotalWinningAmount(totalMatchCount);
        double winningRate = (double) totalWinningAmount / purchasePrice * 100;
        System.out.printf("총 수익률은 %,.1f%%입니다.%n", winningRate);
    }
}
