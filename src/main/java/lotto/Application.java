package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoPurchasePrice = Integer.parseInt(validate(Console.readLine()));
        int lottoPurchaseQuantity = calculateLottoQuantity(lottoPurchasePrice);
        print(lottoPurchaseQuantity);
        List<Integer> numbers = createLottoNumbers();
    }

    private static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void print(int lottoPurchaseQuantity) {
        System.out.println(lottoPurchaseQuantity + "개를 구매했습니다.");
    }

    public static int calculateLottoQuantity(int lottoPurchasePrice) {
        return lottoPurchasePrice / 1000;
    }

    public static String validate(String enterPrice) {
        return enterPrice;
    }
}
