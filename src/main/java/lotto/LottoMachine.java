package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> purchasedLottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusNumber;

    public void buyLottos(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        int count = amount / LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.%n", count);
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            purchasedLottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }
    }

    public void setWinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningLotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public void calculateResults() {
        int[] prizeCount = new int[5];
        long totalPrize = 0;

        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                prizeCount[0]++;
                totalPrize += 2_000_000_000;
            } else if (matchCount == 5 && bonusMatch) {
                prizeCount[1]++;
                totalPrize += 30_000_000;
            } else if (matchCount == 5) {
                prizeCount[2]++;
                totalPrize += 1_500_000;
            } else if (matchCount == 4) {
                prizeCount[3]++;
                totalPrize += 50_000;
            } else if (matchCount == 3) {
                prizeCount[4]++;
                totalPrize += 5_000;
            }
        }

        printResults(prizeCount, totalPrize);
    }

    private void printResults(int[] prizeCount, long totalPrize) {
        String[] prizeDescriptions = {
                "6개 일치 (2,000,000,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "5개 일치 (1,500,000원)",
                "4개 일치 (50,000원)",
                "3개 일치 (5,000원)"
        };

        System.out.println("당첨 통계\n---");
        for (int i = 0; i < prizeCount.length; i++) {
            System.out.printf("%s - %d개%n", prizeDescriptions[i], prizeCount[i]);
        }

        long spent = purchasedLottos.size() * LOTTO_PRICE;
        double profitRate = (double) totalPrize / spent * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
