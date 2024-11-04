package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();

        int cycle = requestMoneyInput(lotto);
        System.out.println(cycle + "개를 구매했습니다.");


        Lotto.generateRandomNumbers(cycle);

        for (List<Integer> numbers : Lotto.Numbers.getAllRandomNumbers()) {
            System.out.println(numbers);
        }

        List<Integer> lottoNum = requestWinningNumbers(lotto);
        Lotto.Numbers.addInputNumbers(lottoNum);

        int bonus = requestBonusNumber(lotto);
        Lotto.Numbers.addBonusNumber(bonus);

        lotto.scoreCheck();
    }

    private static int requestMoneyInput(Lotto lotto) {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                return lotto.validateMoney(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> requestWinningNumbers(Lotto lotto) {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                return lotto.validateNum(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int requestBonusNumber(Lotto lotto) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                return Lotto.bonusValidate(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}