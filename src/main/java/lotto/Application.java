package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        int purchaseAmount = readPurchaseAmount();
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottos = generateLottos(lottoCount);
        printLottos(lottos);
        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);
        Map<Rank, Integer> results = calculateResults(lottos, winningNumbers, bonusNumber);
        printResults(results);
        double profitRate = calculateProfitRate(results, purchaseAmount);
        printProfitRate(profitRate);
    }

    private int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                int amount = parseAmount(input);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private List<Integer> readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                List<Integer> numbers = parseWinningNumbers(input);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        String[] tokens = input.split(",");
        if (tokens.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int num = parseNumber(token.trim());
            numbers.add(num);
        }
        validateUniqueNumbers(numbers);
        return numbers;
    }

    private int readBonusNumber(List<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                int bonus = parseNumber(input);
                validateBonusNumber(bonus, winningNumbers);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validateBonusNumber(int bonus, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    private Map<Rank, Integer> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> results = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = getRank(lotto, winningNumbers, bonusNumber);
            if (rank != null) {
                results.put(rank, results.getOrDefault(rank, 0) + 1);
            }
        }
        return results;
    }

    private Rank getRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int num : lottoNumbers) {
            if (winningNumbers.contains(num)) {
                count++;
            }
        }
        return count;
    }

    private void printResults(Map<Rank, Integer> results) {
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : Rank.orderedRanks()) {
            int count = results.getOrDefault(rank, 0);
            System.out.println(rank.getMessage() + " - " + count + "개");
        }
    }

    private double calculateProfitRate(Map<Rank, Integer> results, int purchaseAmount) {
        long totalPrize = 0;
        for (Rank rank : results.keySet()) {
            totalPrize += rank.getPrize() * results.get(rank);
        }
        double rate = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(rate * 10) / 10.0;
    }

    private void printProfitRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
