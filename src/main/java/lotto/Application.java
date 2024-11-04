package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    private static final int PRICE_LOTTO = 1000;
    private static final String ERROR_MESSAGE = "[ERROR]"; // ERROR_MESSAGE 추가

    public static void main(String[] args) {
        try {
            int totalAmount = getPurchaseAmount();
            List<Lotto> purchasedLottos = generateLottos(totalAmount);

            displayLottos(purchasedLottos);

            Set<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();

            Map<Rank, Integer> matchResults = calculateResults(purchasedLottos, winningNumbers, bonusNumber);
            displayResults(matchResults);

            double profitRate = calculateProfitRate(matchResults, totalAmount);
            System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        System.out.print("로또 구입 금액을 입력하세요: ");
        try {
            int amount = Integer.parseInt(Console.readLine().trim());
            validatePurchaseAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % PRICE_LOTTO != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private static List<Lotto> generateLottos(int totalAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int count = totalAmount / PRICE_LOTTO;

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static Set<Integer> getWinningNumbers() {
        System.out.print("당첨 번호를 입력하세요 (쉼표로 구분): ");
        String[] input = Console.readLine().split(",");
        Set<Integer> winningNumbers = new HashSet<>();
        for (String number : input) {
            int num = Integer.parseInt(number.trim());
            validateRange(num);
            winningNumbers.add(num);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 6개의 당첨 번호를 입력해야 합니다.");
        }
        return winningNumbers;
    }

    private static int getBonusNumber() {
        System.out.print("보너스 번호를 입력하세요: ");
        int bonus = Integer.parseInt(Console.readLine().trim());
        validateRange(bonus);
        return bonus;
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static Map<Rank, Integer> calculateResults(List<Lotto> lottos, Set<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            Rank rank = Rank.getRank(lotto, winningNumbers, bonusNumber);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return results;
    }

    private static void displayResults(Map<Rank, Integer> results) {
        for (Rank rank : Rank.values()) {
            System.out.printf("%s - %d개%n", rank.getDescription(), results.getOrDefault(rank, 0));
        }
    }

    private static double calculateProfitRate(Map<Rank, Integer> results, int totalAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalPrize / totalAmount) * 100;
    }

    private static void displayLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
