package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    static final int priceOfLottery = 1000;
    static int amountForLottery;
    static Lotto[] purchasedLotteries;

    public static void main(String[] args) {
        readAmount();
        purchaseLottery();
    }
    public static void validateAmount(int input) {
        if(input <= 0 || input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
    public static void readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int input;
        try {
            input = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 올바른 정수여야 합니다.");
        }
        validateAmount(input);
        amountForLottery = input;
    }
    public static void purchaseLottery() {
        int numberOfPurchase = amountForLottery / priceOfLottery;
        System.out.printf("%d개를 구매했습니다.", numberOfPurchase);
        purchasedLotteries = new Lotto[numberOfPurchase];
        for(int i=0; i<numberOfPurchase; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(randomNumbers.toString());
            purchasedLotteries[i] = new Lotto(randomNumbers);
        }
    }
}
