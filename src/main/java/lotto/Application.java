package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new Application().run();
    }

    public void run() {
        try {
            int purchaseAmount = inputPurchaseAmount();
            List<Lotto> purchasedLottos = makeLotto(purchaseAmount);
            printLottos(purchasedLottos);
            WinningNumber winningNumbers = inputWinningNumbers();
            Map<Rank, Integer> results = calculateResults(purchasedLottos, winningNumbers);
            printResults(results);
            calculateAndPrintProfitRate(purchaseAmount, results);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 올바르지 않습니다. 숫자를 입력해 주세요.");
        }
    }

    private List<Lotto> makeLotto(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private WinningNumber inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNums = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String num : winningNums) {
            winningNumbers.add(Integer.parseInt(num.trim()));
        }
        if (winningNumbers.size() != 6 || hasDuplicates(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return new WinningNumber(winningNumbers, bonusNumber);
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private Map<Rank, Integer> calculateResults(List<Lotto> lottos, WinningNumber winningNumbers) {
        Map<Rank, Integer> results = new HashMap<>();
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            Rank rank = lotto.rank(winningNumbers);
            if (rank != Rank.FAIL) {
                results.put(rank, results.get(rank) + 1);
            }
        }
        return results;
    }

    private void printResults(Map<Rank, Integer> results) {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.FAIL) {
                System.out.println(rank.getMatchMessage() + " - " + results.get(rank) + "개");
            }
        }
    }

    private void calculateAndPrintProfitRate(int purchaseAmount, Map<Rank, Integer> results) {
        long totalProfit = 0;
        for (Rank rank : results.keySet()) {
            totalProfit += (long) rank.getPrize() * results.get(rank);
        }
        double profitRate = ((double) totalProfit / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
