package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
        displayPurchasedLottos(purchasedLottos);

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber();

        Map<Prize, Integer> result = checkWinning(purchasedLottos, winningLotto, bonusNumber);
        displayResults(result, purchaseAmount);
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount;
        while (true) {
            try {
                amount = Integer.parseInt(Console.readLine());
                if (amount % 1000 != 0) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
        }
        return amount;
    }

    private static List<Lotto> purchaseLottos(int amount) {
        int count = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void displayPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static Lotto getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers;
        while (true) {
            try {
                numbers = Arrays.stream(Console.readLine().split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                if (numbers.size() != 6) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
            }
        }
        return new Lotto(numbers);
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus;
        while (true) {
            try {
                bonus = Integer.parseInt(Console.readLine());
                if (bonus < 1 || bonus > 45) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return bonus;
    }

    private static Map<Prize, Integer> checkWinning(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        Map<Prize, Integer> results = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) results.put(prize, 0);

        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Prize prize = Prize.getPrize(matchCount, bonusMatch);
            results.put(prize, results.get(prize) + 1);
        }
        return results;
    }

    private static void displayResults(Map<Prize, Integer> results, int purchaseAmount) {
        System.out.println("당첨 통계\n---");
        double totalPrize = 0;
        for (Prize prize : Prize.values()) {
            int count = results.get(prize);
            System.out.printf("%s - %d개\n", prize.getDescription(), count);
            totalPrize += count * prize.getPrizeMoney();
        }
        double profitRate = (totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
