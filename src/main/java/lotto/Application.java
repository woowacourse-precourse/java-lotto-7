package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

// 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다. 로또 1장의 가격은 1,000원이다.
// 로또 번호의 숫자 범위는 1~45까지이다.
// 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
// 당첨 번호와 보너스 번호를 입력받는다.
// 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
public class Application {
    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        int lottoCount = countLottos(purchaseAmount);
        List<Lotto> lottos = generateLottos(lottoCount);
        displayLottos(lottos);

        Set<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

        Map<Rank, Integer> results = calculateResults(lottos, winningNumbers, bonusNumber);
        displayStatistics(results);

        double profitRate = calculateProfitRate(results, purchaseAmount);
        displayProfitRate(profitRate);
    }

    private static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return parsePurchaseAmount(input);
    }

    private static int parsePurchaseAmount(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            validatePurchaseAmount(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
        }
    }

    private static int countLottos(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private static List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    private static void displayLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    private static Set<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return parseWinningNumbers(input);
    }

    private static Set<Integer> parseWinningNumbers(String input) {
        try {
            String[] tokens = input.split(",");
            if (tokens.length != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
            }
            
            Set<Integer> numbers = new HashSet<>();
            for (String token : tokens) {
                int number = Integer.parseInt(token.trim());
                validateLottoNumber(number);
                if (!numbers.add(number)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
                }
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    private static int inputBonusNumber(Set<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return parseBonusNumber(input, winningNumbers);
    }

    private static int parseBonusNumber(String input, Set<Integer> winningNumbers) {
        try {
            int number = Integer.parseInt(input.trim());
            validateLottoNumber(number);
            if (winningNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private static void validateLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static Map<Rank, Integer> calculateResults(List<Lotto> lottos, Set<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        initializeResults(results);

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean bonusMatch = lotto.containsNumber(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            if (rank != Rank.NONE) {
                results.put(rank, results.get(rank) + 1);
            }
        }
        return results;
    }

    private static void initializeResults(Map<Rank, Integer> results) {
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                results.put(rank, 0);
            }
        }
    }

    private static void displayStatistics(Map<Rank, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Rank[] orderedRanks = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        for (Rank rank : orderedRanks) {
            System.out.println(rank.getDescription() + " - " + results.get(rank) + "개");
        }
    }

    private static double calculateProfitRate(Map<Rank, Integer> results, int purchaseAmount) {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                totalPrize += (long) rank.getPrizeMoney() * results.get(rank);
            }
        }
        return (double) totalPrize / purchaseAmount * 100;
    }

    private static void displayProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}