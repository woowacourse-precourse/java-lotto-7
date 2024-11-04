package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void run() {
        System.out.println("구매금액을 입력해 주세요.");
        int money = getMoney();
        int ticketCount = money / 1000;
        System.out.printf("%d개를 구매했습니다.%n", ticketCount);
        List<Lotto> purchasedLottos = purchaseLottos(ticketCount);
        displayPurchasedLottos(purchasedLottos);

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber();

        checkResults(purchasedLottos, winningLotto, bonusNumber, money);
    }

    private static int getMoney() {
        String input = Console.readLine();
        try {
            int money = Integer.parseInt(input);
            if (money < 1000 || money % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static List<Lotto> purchaseLottos(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    private static void displayPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static Lotto getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분)");
        String input = Console.readLine();
        List<Integer> winningNumbers = parseInputNumbers(input);
        return new Lotto(winningNumbers);
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> parseInputNumbers(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return numbers;
    }

    private static void checkResults(List<Lotto> lottos, Lotto winningLotto, int bonusNumber, int moneySpent) {
        Map<Rank, Integer> matchCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            matchCounts.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = Rank.getRank(lotto.getMatchCount(winningLotto), lotto.containsNumber(bonusNumber));
            matchCounts.put(rank, matchCounts.get(rank) + 1);
        }
        displayResults(matchCounts);
        displayProfit(matchCounts, moneySpent);
    }

    private static void displayResults(Map<Rank, Integer> matchCounts) {
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%s - %d개%n", rank.getMessage(), matchCounts.get(rank));
            }
        }
    }

    private static void displayProfit(Map<Rank, Integer> matchCounts, int moneySpent) {
        long totalProfit = 0;
        for (Rank rank : Rank.values()) {
            totalProfit += (long) rank.getPrize() * matchCounts.get(rank);
        }
        double profitRate = (double) totalProfit / moneySpent * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static final String ERROR_MESSAGE = "[ERROR]";
}