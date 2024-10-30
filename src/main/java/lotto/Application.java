package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    static int profit = 0;
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
