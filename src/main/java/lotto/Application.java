package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }
}

class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public void start() {
        try {
            int purchaseAmount = getPurchaseAmount();
            List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
            List<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();

            System.out.println("당첨 통계\n---");
            Result result = new Result(purchasedLottos, winningNumbers, bonusNumber);
            result.calculateAndDisplayResults(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        System.out.println((amount / LOTTO_PRICE) + "개를 구매했습니다.");
        return amount;
    }

    private List<Lotto> purchaseLottos(int amount) {
        int numberOfLottos = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }

    private List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        if (input.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        List<Integer> numbers = new ArrayList<>();
        for (String number : input) {
            int parsedNumber = Integer.parseInt(number.trim());
            validateNumberRange(parsedNumber);
            numbers.add(parsedNumber);
        }
        return numbers;
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        validateNumberRange(bonusNumber);
        return bonusNumber;
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}



class Result {
    private final List<Lotto> purchasedLottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Result(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void calculateAndDisplayResults(int purchaseAmount) {
        int[] matchCounts = new int[5];
        int totalPrize = 0;

        for (Lotto lotto : purchasedLottos) {
            int matchCount = calculateMatchCount(lotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            int prize = getPrize(matchCount, bonusMatch);
            totalPrize += prize;
            updateMatchCounts(matchCounts, matchCount, bonusMatch);
        }

        displayResults(matchCounts);
        displayProfitRate(totalPrize, purchaseAmount);
    }

    private int calculateMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private int getPrize(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return 2_000_000_000;
        if (matchCount == 5 && bonusMatch) return 30_000_000;
        if (matchCount == 5) return 1_500_000;
        if (matchCount == 4) return 50_000;
        if (matchCount == 3) return 5_000;
        return 0;
    }

    private void updateMatchCounts(int[] matchCounts, int matchCount, boolean bonusMatch) {
        if (matchCount == 6) matchCounts[0]++;
        if (matchCount == 5 && bonusMatch) matchCounts[1]++;
        if (matchCount == 5) matchCounts[2]++;
        if (matchCount == 4) matchCounts[3]++;
        if (matchCount == 3) matchCounts[4]++;
    }

    private void displayResults(int[] matchCounts) {
        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCounts[4]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCounts[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCounts[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCounts[1]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCounts[0]);
    }

    private void displayProfitRate(int totalPrize, int purchaseAmount) {
        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
