package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        Lotto lotto = new Lotto();
        int cycle = lotto.validateMoney(input);
        System.out.println(cycle + "개를 구매했습니다.");

        Lotto.generateRandomNumbers(cycle);

        for (List<Integer> numbers : Lotto.Numbers.getAllRandomNumbers()) {
            System.out.println(numbers);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        input = Console.readLine();
        List<Integer> lottoNum = lotto.validateNum(input);

        System.out.println("보너스 번호를 입력해 주세요.");
        input = Console.readLine();
        lotto.bounusValidate(input);

        System.out.println(Lotto.Numbers.showNum());
    }
}
