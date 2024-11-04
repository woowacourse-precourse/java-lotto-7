package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> publishRandomLotteryNumbers(int lotteryPurchaseAmount) {
        int lotteryCount = lotteryPurchaseAmount / LOTTO_PRICE;
        System.out.println("\n" + lotteryCount + "개를 구매했습니다.");

        List<Lotto> randomLotteryNumbers = new ArrayList<>();
        for (int i = 0; i < lotteryCount; i++) {
            randomLotteryNumbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return randomLotteryNumbers;
    }

    public static void printRandomLotteryNumbers(List<Lotto> randomLotteryNumbers) {
        for (Lotto randomLotteryNumber : randomLotteryNumbers) {
            System.out.println(randomLotteryNumber.getNumbers());
        }
        System.out.println();
    }
}
