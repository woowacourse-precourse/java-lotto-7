package lotto;

import java.util.Scanner;

public class Consumer { // 로또 구매자
    private int lottoCount;
    private int totalLottoCost;

    public Consumer() {
        Scanner sc = new Scanner(System.in);

        lottoCount = sc.nextInt();

        totalLottoCost = sc.nextInt();

        validateTotalLottoCost(totalLottoCost);
    }

    private void validateTotalLottoCost(int totalLottoCost) {
        if (totalLottoCost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다.");
        }
    }

    // Getter methods (optional)
    public int getLottoCount() {
        return lottoCount;
    }

    public int getTotalLottoCost() {
        return totalLottoCost;
    }
}
