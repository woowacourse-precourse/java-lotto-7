package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    // 각 등수의 상금
    private static final int[] PRIZES = {2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000};

    private List<Lotto> purchasedLottos;

    public LottoGame() {
        this.purchasedLottos = new ArrayList<>();
    }

    public void purchaseLottos(int amount) {
        int count = amount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            purchasedLottos.add(generateLotto());
        }
        displayPurchasedLottos();
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
        return new Lotto(numbers);
    }

    private void displayPurchasedLottos() {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void checkResults(List<Integer> winningNumbers, int bonusNumber) {
        int[] results = new int[5]; // 1등부터 5등까지의 결과를 저장
        int totalPrize = 0;

        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();

            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                results[0]++; // 1등
                totalPrize += PRIZES[0];
            } else if (matchCount == 5 && bonusMatch) {
                results[1]++; // 2등
                totalPrize += PRIZES[1];
            } else if (matchCount == 5) {
                results[2]++; // 3등
                totalPrize += PRIZES[2];
            } else if (matchCount == 4) {
                results[3]++; // 4등
                totalPrize += PRIZES[3];
            } else if (matchCount == 3) {
                results[4]++; // 5등
                totalPrize += PRIZES[4];
            }
        }
        displayResults(results);
        displayProfitRate(totalPrize);
    }

    private void displayResults(int[] results) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + results[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + results[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results[0] + "개");
    }

    private void displayProfitRate(int totalPrize) {
        int totalSpent = purchasedLottos.size() * LOTTO_PRICE;
        double profitRate = (double) totalPrize / totalSpent * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}