package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Result.*;

public class Application {
    static double profit = 0;
    static int bonus = 0;
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        System.out.println();

        int count = Integer.parseInt(money) / 1000;
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = createLottos(count);
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = winningNumbers(winNumbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = Integer.parseInt(Console.readLine());
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");
        checkNumber(lottos, winningNumbers);
    }
    private static void checkNumber(List<Lotto> lottos, List<Integer> winningNumbers) {
        int collect = 0;
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            collect = lotto.countCollect(numbers, winningNumbers);
            checkResult(collect, lotto, numbers);
        }
    }
    private static void checkResult(int collect, Lotto lotto, List<Integer> numbers) {
        Result result = null;
        if (collect == 3) result = Result.Three;
        if (collect == 4) result = Result.Four;
        if (collect == 5) {
            if (lotto.checkBonus(numbers,bonus)) result = Result.Bonus;
            if (!lotto.checkBonus(numbers,bonus)) result = Result.Five;
        }
        if (collect == 6) result = Result.Six;
        if (result != null) {
            profit += result.getPrice();
        }
    }
    private static List<Integer> winningNumbers(String[] input) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : input) {
            winningNumbers.add(Integer.parseInt(number));
        }
        System.out.println();
        return winningNumbers;
    }
    private static List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            System.out.println(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
