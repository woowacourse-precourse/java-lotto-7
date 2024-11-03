package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        try {
            new Application().run();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + " " + e.getMessage());
        }
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int ticketCount = purchaseAmount / LOTTO_PRICE;

        List<Lotto> purchasedLottos = generateLottos(ticketCount);
        displayLottos(purchasedLottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        displayResults(purchasedLottos, winningNumbers, bonusNumber, purchaseAmount);
    }

    private int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine().trim());

        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return amount;
    }

    private List<Lotto> generateLottos(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
        return lottos;
    }

    private void displayLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String num : input) {
            int number = Integer.parseInt(num.trim());
            validateNumberRange(number);
            numbers.add(number);
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        return numbers;
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());
        validateNumberRange(bonusNumber);

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
        return bonusNumber;
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void displayResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        Map<Rank, Integer> results = new HashMap<>();

        for (Lotto lotto : lottos) {
            Rank rank = lotto.getRank(winningNumbers, bonusNumber);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        System.out.println("당첨 통계\n---");
        int totalPrize = 0;

        for (Rank rank : Rank.values()) {
            int count = results.getOrDefault(rank, 0);
            if (rank != Rank.NONE) {
                System.out.printf("%d개 일치%s (%d원) - %d개%n",
                        rank.matchCount, rank.hasBonus ? ", 보너스 볼 일치" : "", rank.prize, count);
            }
            totalPrize += rank.prize * count;
        }

        double yield = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}
