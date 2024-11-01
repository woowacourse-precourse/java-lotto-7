package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.io.InputReader;
import lotto.strategy.LotteryNumberGenerator;

public class Application {
    public static void main(String[] args) {

        InputReader inputReader = new InputReader();

        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = inputReader.totalPurchaseAmount();
        System.out.println();

        System.out.println(purchaseAmount + "개를 구매했습니다.");
        List<List<Integer>> a = LotteryNumberGenerator.generateNumbers(purchaseAmount);
        System.out.println(a);



    }
}
